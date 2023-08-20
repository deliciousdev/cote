package test;

import java.util.*;
import java.io.*;

/**
 * 단순구현
 * 정렬을 이용해야하므로 그리디 로 분류 되는듯..?
 */
public class P1213 {

    static FastReader sc= new FastReader();

    static int[] cnt= new int['Z'-'A'+1];
    static char alphabetThatCntIsOdd;
    public static void main(String[] args){
        solve1();
    }
    static void solve1(){
        String s= sc.next();
        for(int i=0; i<s.length(); ++i){
            ++cnt[s.charAt(i)-'A'];
        }

        if(!validate(s,cnt)) {
            System.out.print("I'm Sorry Hansoo");
            System.exit(0);
        }

        String answer = makePalindrome(s);

        System.out.print(answer);
    }

    static String makePalindrome(String s){
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<cnt.length; ++i){
            int temp=cnt[i]/2;
            while(temp-->0){
                sb.append((char)(i+'A'));
            }
        }
        StringBuilder temp = new StringBuilder(sb);
        if(s.length()%2==1){
            sb.append(alphabetThatCntIsOdd);
        }

        sb.append(temp.reverse());

        return sb.toString();
    }
    static boolean validate(String s,int[] cnt){
        char theNumberThatCntIsOdd =0;
        for(int i=0; i<cnt.length; ++i){
            if(cnt[i]%2==0) continue;

            alphabetThatCntIsOdd=(char)(i+'A');
            ++theNumberThatCntIsOdd;
            if(theNumberThatCntIsOdd>1) return false;
        }
        return s.length()%2==0 && theNumberThatCntIsOdd==0 || s.length()%2==1 && theNumberThatCntIsOdd==1;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}

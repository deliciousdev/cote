package test;

import java.util.*;
import java.io.*;

/**
 * 부르트포스 구현
 */
public class P1062 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,K;

    static char[] selected;
    static Set[] words;

    static int ans=Integer.MIN_VALUE;
    public static void main(String[] args){
        N=sc.nextInt();
        K=sc.nextInt();
        if(K <5){
            System.out.print(0);
            System.exit(0);
        }

        words=new Set[N];
        for(int i=0; i<N; ++i){
            words[i]= new HashSet<Character>();
        }
        for(int i=0; i<words.length; ++i){
             char[] c= sc.next().replace("a","").replace("c","")
                    .replace("i","").replace("n","").replace("t","").toCharArray();

             for(int j=0; j<c.length; ++j){
                 words[i].add(c[j]);
             }
        }

        selected= new char[K-5];
        solve1();

    }

    static void solve1(){

        bruteForce_combination(0,'a'-1);
        System.out.print(ans);
    }
    static void bruteForce_combination(int k, int s){
        if(k== K-5){
            int readableCnt=countReadableWord();
//            int readableCnt=countReadableWord2(); //오히려 더걸림
            ans=Math.max(ans,readableCnt);
            return;
        }
        for(int i=s+1; i<'z'+1; ++i){
            if(i=='a'||i=='c'|| i=='i' ||i=='n'||i=='t') continue;

            selected[k]=(char)i;
            bruteForce_combination(k+1,i);
        }
    }

    static int countReadableWord2(){
        int readableCnt=0;
        for(Set<Character> wds:words){
            int cnt=0;
            for(char c : wds){
                for(int i=0; i<selected.length; ++i){
                    if(c==selected[i]){
                        ++cnt;
                        break;
                    }
                }
            }
            if(cnt==wds.size()){
                ++readableCnt;
            }
        }
        return readableCnt;
    }
    static int countReadableWord(){
        int readableCnt=0;
        for(Set<Character> word:words){
            if(word.size()==0){
                ++readableCnt;
                continue;
            }

            int cnt=0;
            for(char c : selected){
                if(word.contains(c)){
                    ++cnt;
                    if(cnt==word.size()){
                        ++readableCnt;
                        break;
                    }
                }
            }

        }
        return readableCnt;
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
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

package part1.자료구조알고리즘1.ch01문자열.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구현,문자열
 * String.toUppercase()
 */
public class _04Q1157_ {

    static FastReader sc= new FastReader();

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        char[] input = sc.next().toUpperCase().toCharArray();
        int[] cnt= new int['Z'-'A'+1];

        for(char c:input){
            ++cnt[c-'A'];
        }

        int mxCnt=-1;
        char ans=0; //인덱스 정보를 갖고있어도되긴한데, 물음표 처리를 위해서는 그냥 알파벳 정보를 들고 있는게 더 나음
        for(int i=0; i<cnt.length; ++i){
            if(cnt[i]>mxCnt){
                mxCnt=cnt[i];
                ans=(char)(i+'A');
            }
            else if(cnt[i]==mxCnt){
                ans='?';
            }
        }
        System.out.print(ans);
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}

package part5.단기완성알고리즘._04투포인터;

import java.util.*;
import java.io.*;

/**
 * N^2 으로 하면 시간초과 -> 다른 방법으로 탐색 해야함 : 투포인터
 * 문제속 포인트 : 연속된 문자열 -> 투포인터로 가능 할 지도 ??
 * N=26 일때 최대 길이인 10^5 이므로 int 로 커버가능 : 이거 꼭 고려해 줘야함
 */
public class _05Q16472 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;

    public static void main(String[] args){
        solve1();
//        solve2();//카운팅을 map 으로 관리 해도되긴함
    }

    static void solve1(){
        N= sc.nextInt();

        char[] arr= sc.next().toCharArray();
        int[] used =new int['z'+1];

        int ans=Integer.MIN_VALUE;
        int usedCnt=1;
        int p1=0;
        int p2=0;
        int l=1;
        ++used[arr[p1]];
        for(;p1<arr.length;++p1){

            while(p2+1<arr.length ){
                char nextChar = arr[p2+1];
                if(used[nextChar]==0 && usedCnt==N){
                    break;
                }

                ++p2;
                ++l;
                if(used[nextChar]==0){
                    ++usedCnt;
                }
                ++used[nextChar];

            }
            ans=Math.max(ans,l);
            --used[arr[p1]];
            if(used[arr[p1]]==0){
                --usedCnt;
            }
            --l;
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

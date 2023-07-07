package part5.단기완성알고리즘._02정렬;

import java.util.*;
import java.io.*;

public class _03Q11652 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    public static void main(String[] args){
//        solve1(); //map 이용
        solve2(); //정렬이용 : 정렬하고 나면 같은 수들은 모여짐 -> 카운팅 하기쉬움
    }

    static void solve2(){

        N= sc.nextInt();

        long[] arr = new long[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long ans=Long.MAX_VALUE;
        int cnt=0;
        int mxCnt=Integer.MIN_VALUE;
        long current=arr[0];
        for(int i=0; i<N; ++i){
            if(current==arr[i]){
                ++cnt;
            }
            else{
                cnt=1;
                current=arr[i];
            }

            if(cnt>mxCnt){
                ans=current;
                mxCnt=cnt;
            }
        }

        System.out.print(ans);

    }
    static void solve1(){
        N=sc.nextInt();
        Map<Long,Integer> map = new HashMap();

        for(int i=0; i<N; ++i){
            map.merge(sc.nextLong(),1,Integer::sum);
        }

        long ans=Long.MAX_VALUE;
        int cnt=0;

        for (Long key : map.keySet()) {
            int value = map.get(key);
            if(cnt<value ){
                cnt=value;
                ans= key;
            }
            else if( cnt==value && key<ans){
                ans=key;
            }
        }
        System.out.print(ans);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str= "";
            try{
                str= br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }

}

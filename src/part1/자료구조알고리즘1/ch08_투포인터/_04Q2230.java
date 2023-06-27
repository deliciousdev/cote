package part1.자료구조알고리즘1.ch08_투포인터;


import java.util.*;
import java.io.*;

/**
 * 강의에서 초기값 하는 여러가지 방법 참고. 나랑 코드 다르긴함
 */
public class _04Q2230 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    public static void main(String[] args){
//        solve1();//380ms : 투포인터 : 무조건 갱신하는식으로해야함 : NlogN(정렬전처리)+ N + N -> NlogN
        solve2();//464ms : 바이너리서치 : 사실 이게 lowerBound 임
//        solve3(); //바이너리서치를 이용하는데, lowerBound 를 찾아서 하는것도 방법임.
    }

    static void solve1(){

        N= sc.nextInt();
        M= sc.nextInt();

        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int p1=0;
        int p2=0;
        int minD = Integer.MAX_VALUE;
        int d=0;
        while(p2<=N-1 && p1<=p2){

            d = arr[p2]-arr[p1];
            if(d<M){ //p1==p2일때는 항상 여기에 걸려서 p2가 증가하게됨
                ++p2;
            }
            else{
                minD= Math.min(minD,d);
                ++p1;
            }
        }
        p2=N-1;//위 while 을 빠져나올때는 항상 p2==N 인상태임
        while(p1<=N-1 && d>=M){
            d=arr[p2]-arr[p1];
            minD=Math.min(minD,d);
            ++p1;
        }

        System.out.print(minD);
    }
    static void solve2(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int minD = Integer.MAX_VALUE;

        for(int i=0; i<N; ++i) {

            int left = i;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                int d= arr[mid]-arr[i];
                if(d<M){
                    left=mid+1;
                }
                else if(d>M){
                    right=mid-1;
                    minD= Math.min(minD,d);
                }
                else{
                    System.out.print(M);
                    System.exit(0);
                }
            }
        }
        System.out.print(minD);
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
    }
}

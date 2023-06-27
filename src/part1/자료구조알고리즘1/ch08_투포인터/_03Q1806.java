package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

/**
 * 이전의 탐색의 결과 덕분에 p2 포인터는 오른쪽으로만 탐색 하면됨 ( p2가 줄어들면 이전의 탐색 했던 것보다 작은거 기 때문에 볼 필요가 없음)
 * 투포인터를 간파하는 핵심 : 이전 조사에 대한 경계값을 통해서 불필요한 조사값을 생략 할 수 있는가 -> 투포인터 가능
 */
public class _03Q1806 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;

    public static void main(String[] args){

        solve1(); // 투포인터 : N : 누적합 이용하는것이 아닌데 엣지케이스등 컨트롤이 잘안됨.. : 강의 코드가 좀더 깔끔하니 참고할것
//        solve2(); //투포인터, 누적합
        //solve3(); // 이진탐색 NlogN: 자연수 수열이므로 이진탐색으로 풀수도 있음 :
    }

    static void solve1(){
        N= sc.nextInt();
        S= sc.nextInt();
        int[] arr= new int[N];
        int mx=Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
            mx= Math.max(arr[i],mx);
        }
        if(mx>=S){
            System.out.print(1);
            System.exit(0);
        }

        int p1=0;
        int p2=0;
        int sum=arr[0];
        int length=1;
        int minLength=Integer.MAX_VALUE;
        while(p2<=N-2 ){

            if(sum<S ){
                sum+=arr[++p2];
                ++length;
            }
            else {
                minLength=Math.min(minLength,length);
                sum-=arr[p1++];
                --length;
            }

        }
        while(sum>=S && p1<=N-1){
            minLength = Math.min(minLength, length);
            sum-=arr[p1++];
            --length;
        }

        System.out.print(minLength !=Integer.MAX_VALUE ? minLength:0);
    }

    static void solve2(){
        N=sc.nextInt();
        S=sc.nextInt();
        int[] acc = new int[N+1];
        for(int i=1; i<=N; ++i){
            int temp = sc.nextInt();
            acc[i]=acc[i-1]+temp;
            if(temp>=S){
                System.out.print(1);
                System.exit(0);
            }
        }

        int p1=1;
        int p2=1;

        int length=1;
        int minLength = Integer.MAX_VALUE;
        while(p2<=N){

            int sum = acc[p2]-acc[p1-1];
            if(sum<S){
                ++p2;
                ++length;
            }
            else{
                minLength= Math.min(minLength,length);
                ++p1;
                --length;
            }
        }
        System.out.print(minLength != Integer.MAX_VALUE? minLength: 0);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null ||!st.hasMoreElements()){
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

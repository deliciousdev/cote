package part1.자료구조알고리즘1.ch07_이분탐색;


import java.util.*;
import java.io.*;

/**
 * 이문제는 문제 조건을 잘 보고 범위의 left righth 범위 초기값이 중요함
 * 시간 복잡도 : N log(K)
 * 특정 문제에서는 조건을 만족하는 값을 구하지 못할 수도 있음. 이럴때에는 ans=mid 로 ans 를 갱신하는식으로 해서  마지막에 ans 를 검사하여 초기값그대로면 갱신이 안된거임
 */
public class _09Q6236 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M;

    public static void main(String[] args){
        solve1();

    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();

        int[] arr= new int[N];

        int max=Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
            max= Math.max(arr[i],max);
        }

        int left= max; //
        int right= 1000000000;
        while(left<=right){
            int mid= (left+right)/2;

            int cnt = calcCnt(arr,mid);
            if(cnt>M){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.print(left);
    }

    static int calcCnt(int[] arr, int withdraw){
        int cnt=1;
        int remain=withdraw;
        for(int i=0; i<arr.length; ++i){

            if(remain<arr[i]){
                ++cnt;
//                if(cnt>M) return M+1; //이거 넣으면 오히려 시간이 조금 더 걸리네...316ms -> 332ms

                remain=withdraw;
            }
            remain -= arr[i];
        }
        return cnt;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

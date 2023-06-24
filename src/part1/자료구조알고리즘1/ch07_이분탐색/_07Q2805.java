package part1.자료구조알고리즘1.ch07_이분탐색;

import java.util.*;
import java.io.*;

/**
 * 문제 컨셉자체가 되는 경우와 안되는경우의 경계값을 구하는 컨셉임
 *
 * 바이너리 서치 이긴한데 한번 생각해보면 정렬이런게 필요 없긴함
 */
public class _07Q2805 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){

//        solve1(); // 984ms : cutSum 을 누적합으로 구할려고 정렬과정을 2번이나함.
        solve2(); //552ns : 정렬없이 진행
    }

    static void solve1(){
        int N= sc.nextInt();
        int M= sc.nextInt();
        int[] arr = new int[N+1];

        for(int i=1; i<=N; ++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long[] acc = new long[N+1];
        for(int i=1; i<=N; ++i){
            acc[i]= acc[i-1]+arr[i];
        }

        int left=0;
        int maxTreeHeight=arr[arr.length-1];
        int right= maxTreeHeight-1;

        while(left<=right){
            int mid=(left+right)/2;
            int upperBoundIndex=calcUpperBoundIndex(arr, mid);
            long cutCnt=(acc.length-1) -(upperBoundIndex)+1;
            long cutSum = (acc[acc.length-1]-acc[upperBoundIndex-1])-(cutCnt)*mid; //cutSum 을 int로 하면 오버플로우 발생

            if(cutSum>M){
                left=mid+1;
            }
            else if(cutSum<M){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.print(right);
    }

    static void solve2(){
        int N= sc.nextInt();
        int M= sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        int left=0;
        int right=1000000000;

        while(left<=right){
            int mid=(left+right)/2;
            long cutSum=calcCutSum(arr,mid);

            if(cutSum>M){
                left=mid+1;
            }
            else if(cutSum<M){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.print(right);
    }
    static int calcUpperBoundIndex(int[] arr , int target){
        int left= 0;
        int right= arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right= mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    static long calcCutSum(int[] arr, int h){
        long sum=0;
        for(int i=0; i<arr.length; ++i){
            if(arr[i]>h) {
                sum += arr[i] - h;
            }
        }
        return sum;
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

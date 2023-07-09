package part5.단기완성알고리즘._03이분탐색;


import java.util.*;
import java.io.*;

public class __06P2512 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;
    static int mxArr;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
            mxArr=Math.max(mxArr,arr[i]);
        }
        M= sc.nextInt();

        int ans= Integer.MIN_VALUE;

        ans= binarySearch(arr,M);
        System.out.print(ans);
    }

    static int binarySearch(int[] arr, int M){

        int left=1;
        int right=mxArr; //이게 M 이면 안되고 mxArr 이어야함
        //M인경우에, 배정후에 돈이 많이 남게 될 수도 있음.

        int maxValidBudget=0;
        while(left<=right){
            int mid=(left+right)/2;

            int totalBudget = calcTotalBudget(arr,mid);

            if(totalBudget>M){
                right=mid-1;
            }
            else{
                maxValidBudget=mid;
                left=mid+1;
            }
        }
        return maxValidBudget;
    }

    static int calcTotalBudget(int[] arr, int validBudgetUpperBound){
        int sum=0;
        for(int i=0; i<arr.length; ++i){
            if(arr[i]>validBudgetUpperBound){
                sum+=validBudgetUpperBound;
            }
            else{
                sum+=arr[i];
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

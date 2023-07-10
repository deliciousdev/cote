package part5.단기완성알고리즘._03이분탐색;


import java.util.*;
import java.io.*;

public class __07P2343 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N = sc.nextInt();
        M= sc.nextInt();

        int[] arr= new int[N];
        int mx=Integer.MIN_VALUE;

        int sum=0;
        for(int i=0; i<N; ++i){
            int temp = sc.nextInt();
            arr[i] = temp;
            mx= Math.max(mx,temp);
            sum+=temp;
        }


        int left=mx;
        int right=sum;

        int ans=0;
        while(left<=right){
            int mid= (left+right)/2;

            int cnt= calcCnt(arr,mid);
            if(cnt<=M){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.print(ans);
    }

    static int calcCnt(int[] arr, int volume){
        int sum=0;
        int cnt=1;
        for(int i=0; i<arr.length; ++i){
            if(sum+arr[i]<=volume){
                sum+=arr[i];
            }
            else{
                ++cnt;
                sum=arr[i];
            }
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

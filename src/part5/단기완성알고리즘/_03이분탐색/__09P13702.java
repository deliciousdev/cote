package part5.단기완성알고리즘._03이분탐색;


import java.util.*;
import java.io.*;

/**
 * left+right 에서 오버플로우가 발생하는 경우가 있을 수 있는경우 : 물론 그냥 long 으로 해도되긴함
 * int mid=left +(right-left)/2;
 */
public class __09P13702 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,K;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        K= sc.nextInt();
        int[] arr= new int[N];
        int mn= Integer.MAX_VALUE;
        int mx= Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            int temp= sc.nextInt();
            arr[i] = temp;
            mn = Math.min(mn,temp);
            mx= Math.max(mx,temp);
        }

//        int left=0; //무한루프 야기 가능성
        int left=1;
        int right= mx;
//        int right=mn;

        int ans=-1;
        while(left<=right){
            int mid=left +(right-left)/2;

            int cnt= determinate(arr,K,mid);
            if(cnt>=K){
                ans= mid;
                left=mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.print(ans);
    }

    static int determinate(int[] arr, int numPeople,int volumePerPerson ){
        int cnt=0;

        Loop1:for(int i=0; i<arr.length; ++i){
            int remain=arr[i];
            while(remain>=volumePerPerson){
                ++cnt;
                remain-=volumePerPerson;
                if(cnt>=numPeople) {
                    break Loop1;
                }
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

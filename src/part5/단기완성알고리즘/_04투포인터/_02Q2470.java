package part5.단기완성알고리즘._04투포인터;

import java.util.*;
import java.io.*;

/**
 *  최대값 + 최소값 을 해본후 양수이면 최대값입장에서는 짝을 찾은거임 -> 최대값 포인터를 줄여주면됨. ( 더이상 최대값 포인터를 고정 시킨채로 탐색 할 필요 없음)
 *  최대값 + 최소값을 해본후 음수이면 최소값 입장에서는 짝을 찾은거임 -> 최소값 포인터를 높히면됨 ( 더이상 최소값 포인터를 고정 시킨채로 탐색 할 필요 업음)
 *  볼필요 없는 탐색은 배제하고, 꼭 탐색 해볼 부분만 포인터를 움직여가면서 본다.
 * 시간 복잡도 : 정렬 + 투포인터 = NlogN + N  -> NlogN
 */
public class _02Q2470 {


    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;

    public static void main(String[] args){

//        solve1();
        solve2(); //모범답안
    }

    static void solve2(){
        N=sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int p1=0;
        int p2= arr.length-1;

        int ansP1=0;
        int ansP2= arr.length-1;

        int minAbs= Integer.MAX_VALUE;

        while(p1<p2){
            int currentSum= arr[p1]+arr[p2];
            int currentAbs= Math.abs(currentSum);
            if(currentSum==0){
                System.out.print(arr[p1]+" "+arr[p2]);
                System.exit(0);
            }
            if(currentAbs<minAbs){
                minAbs=currentAbs;
                ansP1=p1;
                ansP2=p2;
            }
            if(currentSum>0){
                --p2;
            }
            else{
                ++p1;
            }
        }
        System.out.print(arr[ansP1]+" "+arr[ansP2]);
    }

    static void solve1(){
        N= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int p1=0;
        int p2=arr.length-1;

        int ansP1=0;
        int ansP2=arr.length-1;


        int minAbs= Integer.MAX_VALUE;

        for(p1=0; p1<arr.length &&p1<p2; ++p1){

            int currentSum=arr[p1]+arr[p2];
            int currentAbs = Math.abs(currentSum);

            if(currentAbs==0){
                System.out.print(arr[p1]+" "+arr[p2]);
                System.exit(0);
            }

            if(currentAbs<minAbs){
                minAbs=currentAbs;
                ansP1=p1;
                ansP2=p2;
            }
            while(p1<p2-1 && currentSum>0){
                --p2;
                currentSum=arr[p1]+arr[p2];
                currentAbs=Math.abs(currentSum);
                if(currentAbs==0){
                    System.out.print(arr[p1]+" "+arr[p2]);
                    System.exit(0);
                }
                if(currentAbs<minAbs){
                    minAbs=currentAbs;
                    ansP1=p1;
                    ansP2=p2;
                }

            }

            if(currentAbs<minAbs){
                minAbs=currentAbs;
                ansP1=p1;
                ansP2=p2;
            }
        }
        System.out.print(arr[ansP1]+ " "+arr[ansP2]);
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

package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

/**
 * 다시 해야함 강의도 다시 봐야함
 * 모듈러를 이용한 반시계 구하기
 * 배열을 이용해서 환형구조를 나타낼때 배열을 2배로 늘리면 더 편하기도함.( 이렇게 하면 모듈러 안해도됨)
 *
 */
public class _06Q2118 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    
    static int N;

    public static void main(String[] args){
        solve1();//바이너리서치
//        solve2();//투포인터
//        solve3();//2중 반복 : N제곱은 시간초과이긴한데 통과했음.
    }
    static void solve1(){
        N= sc.nextInt();
        int[] arr= new int[N+1]; //arr[i] : i-1 -> i 거리
        int[] acc = new int[2*N+1];//acc[i] : 0 -> i 거리
        for(int i=1; i<=N; ++i){
            arr[i] = sc.nextInt();
            acc[i] = acc[i-1] + arr[i];
        }
//        if(N==2){
//            System.out.print(Math.min(arr[1],arr[2]));
//            System.exit(0);
//        }


        final int total = acc[N];
        final int maxBound = total/2;
        for(int i=N+1; i<=2*N; ++i){
            acc[i] = acc[i-1] + arr[(i-1)%N +1];
        }

        int ans=Integer.MIN_VALUE;
        for(int i=1; i<=N; ++i){
            int left= i+1;
            int right= i+N-1;

            while(left<=right){
                int mid=(left+right)/2;

                int d= acc[mid]-acc[i-1];

                if(d<maxBound){
                    left= mid+1;
                }
                else if(d>maxBound){
                    right= mid-1;
                }
                else{
                    System.out.print(maxBound);
                    System.exit(0);
                }
            }
            int smallD=acc[right]-acc[i-1];
            int bigD = total-acc[left]-acc[i-1];
            int resultD = Math.max(smallD,bigD);
            ans=Math.max(ans,resultD);
        }
        System.out.print(ans);


    }

    static void solve2(){//투포인터
        N=sc.nextInt();
        int[] acc= new int[N+2];
        for(int i=2; i<=N; ++i){
            acc[i] = acc[i-1]+sc.nextInt();
        }
        final int total = acc[N]+sc.nextInt();
        final int maxBound = (total+1)/2;

        int p1=1; int p2=2;

        while(p2<=N){

            int oneD = acc[p2]-acc[p1-1];
            if(oneD<maxBound){
                ++p2;
            }

        }

    }

    static void solve3(){
        N= sc.nextInt();


        int[] acc= new int[N+2];
        for(int i=2; i<=N; ++i){
            acc[i]=acc[i-1]+sc.nextInt();
        }
        final int total = acc[N]+sc.nextInt();
        final int maxBound = (total+1)/2;

        int mxD=Integer.MIN_VALUE;
        for(int i=1; i<=N-1; ++i){
            for(int j=i+1; j<=N; ++j){
                int oneD = acc[j]-acc[i-1];
                int anotherD= total-oneD;
                int d = Math.min(oneD,anotherD);
                if(d>mxD){
                    mxD= d;
                }
            }
        }

        System.out.print(mxD);
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

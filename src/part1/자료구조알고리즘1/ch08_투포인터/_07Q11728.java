package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

public class _07Q11728 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;


    public static void main(String[] args){

//        solve1(); //1652 ms : 그냥정렬
//        solve2(); //1576 ms : 투포인터
//        solve3(); //1508 ms : solve2() 에서 출력은 따로 뺀거
        solve4(); // mIndex는 항상 aIndex+bIndex 임

    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] merge = new int[N+M];
        for(int i=0; i<N; ++i){
            merge[i] =sc.nextInt();
        }
        for(int i=N; i<N+M; ++i){
            merge[i] = sc.nextInt();
        }

        Arrays.sort(merge);
        for(int i=0; i<N+M; ++i){
            sb.append(merge[i]).append(" ");
        }
        System.out.print(sb.toString().trim());

    }

    static void solve2(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        for(int i=0; i<N; ++i){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<M; ++i){
            B[i] = sc.nextInt();
        }

        int[] merge = new int[N+M];
        int pointA =0;
        int pointB=0;

        int mergeIndex=0;
        while(pointA<N && pointB<M){
            if(A[pointA]<B[pointB]){
                merge[mergeIndex]=A[pointA++];
            }
            else{
                merge[mergeIndex]=B[pointB++];
            }
            sb.append(merge[mergeIndex++]).append(" ");
        }
        while(pointA<N){
            merge[mergeIndex]=A[pointA++];
            sb.append(merge[mergeIndex++]).append(" ");
        }
        while(pointB<M){
            merge[mergeIndex]=B[pointB++];
            sb.append(merge[mergeIndex++]).append(" ");
        }

        System.out.print(sb.toString().trim());
    }

    static void solve3(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] A= new int[N];
        int[] B = new int[M];
        for(int i=0; i<N; ++i){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<M; ++i){
            B[i] = sc.nextInt();
        }

        int aIndex=0;
        int bIndex=0;
        int[] merge = new int[N+M];
        int mIndex=0; //mIndex 는 사실 항상 aIndex+bIndex 이긴함
        while(aIndex<N && bIndex<M){
            if(A[aIndex]<B[bIndex]){
                merge[mIndex++]=A[aIndex++];
            }
            else{
                merge[mIndex++]=B[bIndex++];
            }
        }
        while(aIndex<N){
            merge[mIndex++]=A[aIndex++];
        }
        while(bIndex<M){
            merge[mIndex++]=B[bIndex++];
        }

        for(int e : merge){
            sb.append(e).append(" ");
        }
        System.out.print(sb.toString().trim());

    }

    static void solve4(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] A= new int[N];
        int[] B = new int[M];
        for(int i=0; i<N; ++i){
            A[i] = sc.nextInt();
        }
        for(int i=0; i<M; ++i){
            B[i] = sc.nextInt();
        }

        int aIndex=0;
        int bIndex=0;
        int[] merge = new int[N+M];
        while(aIndex<N && bIndex<M){
            if(A[aIndex]<B[bIndex]){
                merge[aIndex+bIndex]=A[aIndex++];
            }
            else{
                merge[aIndex+bIndex]=B[bIndex++];
            }
        }
        while(aIndex<N){
            merge[aIndex+bIndex]=A[aIndex++];
        }
        while(bIndex<M){
            merge[aIndex+bIndex]=B[bIndex++];
        }

        for(int e : merge){
            sb.append(e).append(" ");
        }
        System.out.print(sb.toString().trim());
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

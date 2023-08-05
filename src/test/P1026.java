package test;

import java.util.*;
import java.io.*;

/**
 * primitive 타입은 오름차순 정렬만 가능, 내림차순 할려면 Integer 로 해야함
 */
public class P1026 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static Integer[] A;
    static int[] B;
    public static void main(String[] args){
        solve1();
    }
    static void solve1(){
        N=sc.nextInt();
        A=new Integer[N];
        B= new int[N];
        for(int i=0; i<A.length; ++i){
            A[i]=sc.nextInt();
        }
        for(int i=0; i<B.length; ++i){
            B[i]=sc.nextInt();
        }
//        Arrays.sort(A, (i1,i2)->i1.compareTo(i2)*-1);
//        Arrays.sort(A,Collections.reverseOrder());
//        Arrays.sort(A,(i1,i2)->Integer.compare(i1,i2)*-1);
        Arrays.sort(A,new MyComparator());

        Arrays.sort(B);
        int S=0;
        for(int i=0; i<N; ++i){
            S+=A[i]*B[i];
        }
        System.out.print(S);
    }

    static class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer i1, Integer i2){
          return i1.compareTo(i2)*-1;
        }
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
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

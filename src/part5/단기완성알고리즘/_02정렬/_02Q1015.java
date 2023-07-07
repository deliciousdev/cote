package part5.단기완성알고리즘._02정렬;

import java.util.*;
import java.io.*;

public class _02Q1015 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;


    public static void main(String[] args){
//        solve1(); //정렬 2번
//        solve2(); //정렬 한번만 함
        solve3(); //랭킹을 구하는것을 그냥 N^2 으로 함
    }

    static void solve1(){
        N= sc.nextInt();
        Element[] elements= new Element[N];
        for(int i=0; i<N; ++i){
            int temp=sc.nextInt();
            Element e = new Element();
            e.value= temp;
            e.originalIdx=i;
            elements[i] = e;
        }

        Arrays.sort(elements,(e1,e2)-> {
            return Integer.compare(e1.value,e2.value);
        });

        for(int i=0; i<N; ++i){
            elements[i].rank =i;
        }

        Arrays.sort(elements,(e1,e2)->{
            return Integer.compare(e1.originalIdx,e2.originalIdx);
        });

        for(int i=0; i<N; ++i){
            sb.append(elements[i].rank).append(" ");
        }
        System.out.print(sb.toString().trim());

    }
    static void solve2(){
        N= sc.nextInt();


        Element[] elements= new Element[N];
        Element[] originalIdx=new Element[N];
        for(int i=0; i<N; ++i){
            int temp = sc.nextInt();
            Element e = new Element();
            e.value=temp;
            originalIdx[i] =e;
            elements[i] = e;
        }

        Arrays.sort(elements,(e1,e2)->{
            return Integer.compare(e1.value,e2.value);
        });

        for(int i=0; i<N; ++i){
            elements[i].rank=i;
        }

        for(int i=0; i<N; ++i){
            sb.append(originalIdx[i].rank).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
    static void solve3(){
        N= sc.nextInt();
        int[] arr= new int[N];

        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<N; ++i){
            int rank=0;
            for(int j=0; j<N; ++j){
                if(arr[i]>arr[j]){
                    ++rank;
                }
                else if(arr[i]==arr[j]){
                    if(i>j){
                        ++rank;
                    }
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    static class Element{
        int originalIdx;
        int rank;
        int value;
        Element(){}
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

package test;

import java.util.*;
import java.io.*;

public class P1083 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int[] arr;
    static Integer[] rank;
    static int N;
    static int S;
    static boolean[] done;

    public static void main(String[] args){
        solve1();
    }
    static void solve1(){
        N=sc.nextInt();
        arr=new int[N];
        rank=new Integer[N];
        done= new boolean[N];

        for(int i=0; i<N; ++i){
            int temp=sc.nextInt();
            arr[i]=temp;
            rank[i]=temp;
        }
        S=sc.nextInt();

        Arrays.sort(rank,Comparator.reverseOrder());

        int targetIdx=0;

        while(targetIdx<arr.length){
            for(int targetRank=0; targetRank<rank.length; ++targetRank){
                if(done[targetRank]) continue;

                int num= rank[targetRank];
                int idx= getIdx(num);
                if(idx-targetIdx<=S){
                    move(targetIdx,idx);
                    S-= idx-targetIdx;
                    ++targetIdx;
                    done[targetRank]=true;
                    break;
                }
            }
        }
        print();
    }

    static void move(int targetIdx, int idx){
//        for(int i=idx-1; i>=targetIdx; --i ){
//            swap(i,i+1);
//        }
        int temp=arr[idx];
        for(int i=idx-1; i>=targetIdx; --i){
            arr[i+1]=arr[i];
        }
        arr[targetIdx]=temp;
    }
    static int getIdx(int x){
        for(int i=0; i<arr.length; ++i){
            if(arr[i]==x) return i;
        }
        return -1;
    }

    static void print(){
        for(int i=0; i<arr.length; ++i){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
    static void swap(int idx1, int idx2){
        int temp= arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
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

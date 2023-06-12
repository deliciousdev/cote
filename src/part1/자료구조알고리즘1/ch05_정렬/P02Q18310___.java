package part1.자료구조알고리즘1.ch05_정렬;

import java.io.*;
import java.util.*;

public class P02Q18310___ {

    static int N;
    static int[] arr;

    public static void main(String[] args){
        init();

        Arrays.sort(arr);

        int current = arr[0];
        int index=0;
        for(int i=1; i<N; ++i){
            if(current!=arr[i]){
                current=arr[i];
                if(i<(double)N/2){ //double 로 안하면 짝수, 홀수 구분해줘야함
                    index=i;
                }
                else{
                    break;
                }
            }
        }

        System.out.print(arr[index]);
    }

    static void init() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null|| !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str ="";
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

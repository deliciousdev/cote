package part1.자료구조알고리즘1.ch07_이분탐색;


import java.util.*;
import java.io.*;

/**
 * Set contains 가 반복되는데, 이것을 배열에서 정렬후 이진탐색으로 했음.
 * 반복적인 탐색 은 이진탐색을 고려하자
 * 자료구조에서 어떤 값이 있는지 없는지를 찾을때 바이너리 서치를 고려하자 ( 이런문제들은 contains() 를 binarySearch 로 대체 가능)
 */
public class _03Q2295 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;


    public static void main(String[] args){
        N=sc.nextInt();

//        solve1();//388 ms : Set 이용
        solve2();//844 ms : BinarySearch 이용

    }

    static void solve2(){
        int[] numbers = new int[N];
        for(int i=0; i<N; ++i){
            numbers[i]=sc.nextInt();
        }

        int[] sums= new int[(1+N)*N/2];
        int idx=0;
        for(int i=0; i<N; ++i){
            for(int j=i;j<N; ++j){
                sums[idx++]=numbers[i]+numbers[j];
            }
        }

        Arrays.sort(sums);

        int mx=Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                int subtract = numbers[i]-numbers[j];
//                if(binarySearch(sums,subtract)>=0){ //844 ms
                if(Arrays.binarySearch(sums,subtract)>=0){ //860 ms
                    mx= Math.max(mx,numbers[i]);
                }
            }
        }
        System.out.print(mx);
    }

    static int binarySearch(int[] arr, int target){
        int left=0;
        int right= arr.length-1;
        while(left<=right){

            int mid= (left+right)/2;
            if(arr[mid]>target){
                right= mid-1;
            }
            else if(arr[mid]<target){
                left= mid+1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

    static void solve1(){
        int[] numbers = new int[N];
        for(int i=0; i<N; ++i){
            numbers[i]=sc.nextInt();
        }

        Set sums = new HashSet();
        for(int i=0; i<N; ++i){
            for(int j=i; j<N; ++j){
                sums.add(numbers[i]+numbers[j]);
            }
        }

        int mx = Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                int subtract = numbers[i]-numbers[j];
                if (sums.contains(subtract)) {
                    mx= Math.max(mx,numbers[i]);
                }
            }
        }
        System.out.print(mx);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null|| !st.hasMoreElements()){
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

package test;

import java.util.*;
import java.io.*;

/**
 * k 번째 칸을 포함하는 사각형의 개수를 구함 : 1차원에서 k번째보다 앞에서 시작해야하고, k번째보다 뒤에서 끝나야함
 * k번째 칸을 포함하는 사격형의 경우의수  =  k번째 포함,k번째보다 앞에서 시작하는 경우의수 * k번째포함, k번째보다 뒤에서 끝나는 경우의수
 * 이것을 2차원으로 확장해서 생각해보면됨
 * */
public class P1286 {

    static FastReader sc=new FastReader();
    static int n,m;
    static long[] cnt= new long['Z'+1]; //int 로 하면 오버플로우 남

    static int test=0;

    public static void main(String[] args){
//        solve1();//문제를 잘못 이해했음...
//        solve2();//당연히 시간초과
        solve3(); //올바른 답
    }

    static void solve3(){
        n= sc.nextInt();
        m= sc.nextInt();
        char[][] arr = new char[2*n][2*m];
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; ++i){
            String s = sc.next();
            sb.append(s).append(s);
            arr[i]=sb.toString().toCharArray();
            arr[i+n]=sb.toString().toCharArray();
            sb.setLength(0);
        }

        count(arr);
        print();
    }

    static void count(char[][] arr){
        for(int row=0; row<2*n; ++row){
            for(int col=0; col<2*m; ++col){
                char c = arr[row][col];
                cnt[c]+= (row+1)*(col+1)*(2*n-row)*(2*m-col);
            }
        }
    }

    static void solve2(){
        n= sc.nextInt();
        m= sc.nextInt();
        char[][] arr = new char[2*n][2*m];
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; ++i){
            String s = sc.next();
            sb.append(s).append(s);
            arr[i]=sb.toString().toCharArray();
            arr[i+n]=sb.toString().toCharArray();
            sb.setLength(0);
        }

        countByBruteForce(arr);
        print();
    }

    static void countByBruteForce(char[][] arr){
        for(int horizonLength=1; horizonLength<=2*m; ++horizonLength){
            for(int verticalLength=1; verticalLength<=2*n; ++verticalLength){

                for(int rowStart=0; rowStart+verticalLength-1<2*n; ++rowStart){
                    for(int colStart=0; colStart+horizonLength-1<2*m; ++colStart){

                        for(int row=rowStart; row<rowStart+verticalLength; ++row){
                            for(int col=colStart; col<colStart+horizonLength; ++col){
                                char c = arr[row][col];
                                ++cnt[c];
                            }
                        }
                    }
                }
            }
        }

    }

    static void solve1(){
        n= sc.nextInt();
        m= sc.nextInt();
        char[][] arr = new char[2*n][2*m];
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; ++i){
            String s = sc.next();
            sb.append(s).append(s);
            arr[i]=sb.toString().toCharArray();
            arr[i+n]=sb.toString().toCharArray();
        }


        countHorizontal(arr);
        countVertical(arr);

        print();
    }

    static void countHorizontal(char[][] arr){
        StringBuilder sb= new StringBuilder();
        for(int length=1; length<=2*m; ++length){
            for(int row=0; row<2*n; ++row){
                for(int start=0; start+length-1<arr[0].length; ++start){

                    for(int idx=start; idx<start+length; ++idx){
                        char c = arr[row][idx];
                        ++cnt[c];
                        sb.append(c);
                    }
                    ++test;
                    sb.setLength(0);
                }
            }
        }
    }


    static void countVertical(char[][] arr){
        StringBuilder sb= new StringBuilder();
        for(int length=2; length<=2*n; ++length){
            for(int col=0; col<2*m; ++col){
                for(int start=0; start+length-1<arr.length; ++start){

                    for(int idx=start; idx<start+length; ++idx){
                        char c = arr[idx][col];
                        ++cnt[c];
                        sb.append(c);
                    }
                    ++test;
                    sb.setLength(0);
                }
            }
        }
    }
    static void print(){
        StringBuilder sb= new StringBuilder();
        for(int i='A'; i<='Z'; ++i){
            sb.append(cnt[i]).append("\n");
        }
        System.out.print(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

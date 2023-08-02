package test;

import java.util.*;
import java.io.*;

/**
 * 덱 연습 , 큐나 덱에서 위치 검색 할때
 */
public class P1021 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
//        solve1();
        solve2();
    }
    static void solve2(){
        int N=sc.nextInt();
        int M= sc.nextInt();

        LinkedList<Integer> dq = new LinkedList<>();

        for(int i=1; i<=N; ++i){
            dq.add(i);
        }

        int cnt=0;
        while(M-->0){
            int target=sc.nextInt();
            int leftSide=dq.indexOf(target);
            int rightSide= dq.size()-dq.indexOf(target);
            cnt+=Math.min(leftSide,rightSide);
            while(leftSide<rightSide && leftSide-->0){
                int front = dq.pollFirst();
                dq.addLast(front);
            }
            while(rightSide<=leftSide && rightSide-->0){
                int rear= dq.pollLast();
                dq.addFirst(rear);
            }
            dq.removeFirst();
        }
        System.out.print(cnt);
    }
    static void solve1(){
        int N=sc.nextInt();
        int M= sc.nextInt();

        LinkedList<Integer> dq = new LinkedList<>();

        for(int i=1; i<=N; ++i){
            dq.add(i);
        }

        int cnt=0;
        while(M-->0){
            int target=sc.nextInt();
            int leftSide=dq.indexOf(target);
            int rightSide= dq.size()-dq.indexOf(target);
            if(leftSide<rightSide){
                cnt+=leftSide;
                while(leftSide-->0){
                    int front = dq.pollFirst();
                    dq.addLast(front);
                }
            }
            else{
                cnt+=rightSide;
                while(rightSide-->0){
                    int rear= dq.pollLast();
                    dq.addFirst(rear);
                }
            }
            dq.removeFirst();
        }
        System.out.print(cnt);
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

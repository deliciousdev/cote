package test;

import java.util.*;
import java.io.*;

public class P1174 {

    static FastReader sc= new FastReader();
    static int N;
    static ArrayList<Long> nums = new ArrayList<>();
    public static void main(String[] args){
        N=sc.nextInt();
//        solve1();
        solve2();
    }

    static void solve1(){

        nums.add(-2L);//dummy
        bfs();
        Collections.sort(nums);

        if(N>nums.size()-1){
            System.out.print(-1);
            System.exit(0);
        }
        System.out.print(nums.get(N));
    }
    static void bfs(){
        Queue<Long> q= new LinkedList<>();
        for(int i=0; i<=9; ++i){
            nums.add((long)i);
            q.add((long)i);
        }

        while(!q.isEmpty()){
            long num= q.poll();
//            int lastDigit= (int)num%10; //이거때문에 오버플로우 발생가능성 있음
            int lastDigit=(int)(num%10);//이렇게 해줘야함

            for(int i=lastDigit-1; i>=0; --i){
                long newNumber=num*10+i;
                nums.add(newNumber);
                q.add(newNumber);
            }
        }
    }
    static void solve2(){
        for(int i=0; i<=9; ++i){
            nums.add((long)i);
            dfs(i,i);
        }

        if(N-1>nums.size()-1){
            System.out.print(-1);
            System.exit(0);
        }
        Collections.sort(nums);

        System.out.print(nums.get(N-1));
    }

    static void dfs(int s,long number){

        for(int i=s-1; i>=0; --i){
            long newNumber= number*10+i;
            nums.add(newNumber);
            dfs(i,newNumber);
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

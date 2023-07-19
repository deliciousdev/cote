package part5.단기완성알고리즘._05그래프와탐색;


import java.util.*;
import java.io.*;

/**
 * N이 정확히 언제이고 K가 정확히 언제일때 답의 최대치가 되는지 생각해보자.
 * 문제속 키워드 "가장 빠른 시간" = "최소 개수의 간선이동" : BFS
 */
public class _06Q1697 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,K;

    static int[] moveCnt= new int[100000+1];

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        K=sc.nextInt();
        Arrays.fill(moveCnt,0,moveCnt.length,-1);

        bfs();

        System.out.print(moveCnt[K]);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList();
        moveCnt[N]=0;
        q.add(N);


        Loop1 :while(!q.isEmpty()){
            int p= q.poll();
            for(int i=0; i<3; ++i){
                int nextP= getNextPoint(p,i);
                if(nextP<0 || nextP>100000) continue;
                if(moveCnt[nextP]!=-1) continue;

                moveCnt[nextP]=moveCnt[p]+1;
                if(nextP==K) break Loop1;
                q.add(nextP);
            }
        }
    }

    static int getNextPoint(int current, int i){
        if(i==0){
            return current-1;
        }
        if(i==1){
            return current+1;
        }
        return current*2;
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

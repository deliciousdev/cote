package test;

import java.util.*;
import java.io.*;

/**
 * 각자 다른 패턴끼리는 절대 같이 켜질 수 없음. 같은 패턴끼리는 같이 켜지고 같이 꺼지고 함.
 * 홀수 횟수 : 1,3,5,7... 부르트포스
 * 짝수 횧수 : 0,2,4,6 ... 부르트포스
 */
public class P1034 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M,K;

    static Map<String,Pattern> patterns= new HashMap<>();

    public static void main(String[] args){
        solve1();
    }
    static void solve1(){
        N=sc.nextInt();
        M=sc.nextInt();

        for(int i=0; i<N; ++i){
            String s=sc.next();
            Pattern p = patterns.get(s);
            if(p!=null){
                p.add();
            }
            else{
                patterns.put(s,new Pattern(s));
            }
        }

        K=sc.nextInt();

        int ans=0;
        for(int i=(K%2); i<=K &&i<=M; i+=2){
            for (Pattern p : patterns.values()) {
                if(p.numZero!=i) continue;

                ans=Math.max(ans, p.numPattern);
            }
        }
        System.out.print(ans);
    }

    static class Pattern{
        int numPattern;
        int numZero;

        Pattern(String pattern){
            for(int i=0;i<pattern.length(); ++i ){
                if(pattern.charAt(i)=='0'){
                    ++this.numZero;
                }
            }
            this.numPattern=1;
        }

        void add(){
            ++this.numPattern;
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

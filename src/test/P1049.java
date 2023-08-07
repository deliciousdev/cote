package test;

import java.util.*;
import java.io.*;

/**
 * 결과를 기준으로 논리적으로 생각하면 좋음
 * 과정이 어떻게되든 결국에는 3가지 경우 밖에 없음. 이 3가지 경우의 값들을 비교하면됨.
 * 3가지 결과에만 신경쓰면 되고, 그 결과에 대한 조건은 생각안해도됨.
 */
public class P1049 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;
    static int mnPack=Integer.MAX_VALUE;
    static int mnSingle= Integer.MAX_VALUE;

    public static void main(String[] args){
//        solve1();
        solve2();
    }

    static void solve2(){
        input();
        int allPack=(N/6+1)*mnPack;
        int packAndSingle= (N/6*mnPack)+ (N%6 *mnSingle);
        int allSingle= N*mnSingle;
        int cost = Math.min(Math.min(allPack, packAndSingle), allSingle);
        System.out.print(cost);
    }

    static void solve1(){
        input();

        int cost=0;
        int remainder=0;
        if(mnPack<mnSingle*6){
            cost+=(N/6) *mnPack;
            remainder= N%6;
        }
        else{//pack 이 의미 없다면 그냥 single 로 다삼
            cost+=N*mnSingle;
            remainder=0;
        }

        //pack 이 의미있을때 자투리부분
        if(0<remainder){
            cost += Math.min(mnPack,mnSingle*(remainder));
        }
        System.out.print(cost);
    }

    private static void input() {
        N=sc.nextInt();
        M=sc.nextInt();

        for(int i=0; i<M; ++i){
            mnPack=Math.min(mnPack,sc.nextInt());
            mnSingle=Math.min(mnSingle,sc.nextInt());
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

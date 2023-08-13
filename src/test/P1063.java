package test;

import java.util.*;
import java.io.*;

/**
 * 그냥 구현
 */
public class P1063 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        String kingStart=sc.next();
        String stoneStart= sc.next();
        N=sc.nextInt();
        int kingRow=8-(kingStart.charAt(1)-'0');
        int kingCol=kingStart.charAt(0)-'A';

        int stoneRow=8-(stoneStart.charAt(1)-'0');
        int stoneCol=stoneStart.charAt(0)-'A';

        while(N-->0){
            D d= getD(sc.next());
            int nextKingR=kingRow+d.dr;
            int nextKingC=kingCol+d.dc;
            if(nextKingR<0 || nextKingR>7 || nextKingC<0 || nextKingC>7) continue;

            if(nextKingR==stoneRow && nextKingC==stoneCol){
                int nextStoneR= stoneRow+d.dr;
                int nextStoneC= stoneCol+d.dc;
                if(nextStoneR<0 || nextStoneR>7 || nextStoneC<0 || nextStoneC>7) continue;

                stoneRow=nextStoneR;
                stoneCol=nextStoneC;
            }
            kingRow=nextKingR;
            kingCol= nextKingC;
        }


        sb.append((char)(kingCol+'A')).append(8-kingRow).append("\n")
                .append((char)(stoneCol+'A')).append(8-stoneRow);

        System.out.print(sb.toString());
    }

    static D getD(String s){

        if(s.equals("R")) return new D(0,1);
        if(s.equals("L")) return new D(0,-1);
        if(s.equals("B")) return new D(1,0);
        if(s.equals("T")) return new D(-1,0);
        if(s.equals("RT")) return new D(-1,1);
        if(s.equals("LT")) return new D(-1,-1);
        if(s.equals("RB")) return new D(1,1);
        if(s.equals("LB")) return new D(1,-1);

        return null;
    }

    static class D{
        int dr;
        int dc;
        D(int dr, int dc){
            this.dr= dr;
            this.dc= dc;
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()){
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

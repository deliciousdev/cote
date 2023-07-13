package test;

import java.io.*;
import java.util.*;

public class P10809 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){

        char[] arr= sc.next().toCharArray();
        int[] position= new int['z'-'a'+1];

        Arrays.fill(position,-1);
        for(int i=0; i<arr.length; ++i){
            int c = arr[i]-'a';
            if(position[c]!=-1) continue;

            position[arr[i]-'a']=i;
        }

        for(int i=0; i<position.length; ++i){
            sb.append(position[i]).append(" ");
        }
        System.out.print(sb.toString().trim());

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

package test;

import java.util.*;
import java.io.*;

/**
 * Scanner.hasNextInt()
 */
public class P10951 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
//        solve1(); //틀린풀이
        solve2();
    }

    static void solve2() throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(A+B);
        }
        sc.close();
    }

    static void solve1(){

        String input=sc.nextLine();
        while(!input.equals("")){

            String[] split=input.split(" ");
            int A= Integer.parseInt(split[0]);
            int B= Integer.parseInt(split[1]);
            sb.append(A+B).append("\n");
            input=sc.nextLine();
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

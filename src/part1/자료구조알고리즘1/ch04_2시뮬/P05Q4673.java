package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P05Q4673 {


    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N=10000;
    static boolean[] isSelfNum;
    public static void main(String[] args) {
        isSelfNum = new boolean[N+100];
        Arrays.fill(isSelfNum,true);

        for(int i=1; i<=N; ++i){
            isSelfNum[d(i)]=false;
        }

        for(int i=1; i<=N; ++i){
            if(isSelfNum[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    static int d(int n){
        int result= n;

        while(n>0){
            result += n%10;
            n/=10;
        }
        return result;
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){

            while (st == null || !st.hasMoreElements()) {
                try {

                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str="";

            try{
                str = br.readLine();
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

package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class p03Q2231 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int ans;

    public static void main(String[] args) {
        init();

        for(int i=1; i<N; ++i){
            if(sumDigit(i)==N){
                ans=i;
                break;
            }
        }

        System.out.println(ans);
    }

    public static void init(){
        N = sc.nextInt();
        ans=0;
    }

    public static int sumDigit(int x){
        int temp=x;

        int result=x;
        while(temp>0){
            result += temp%10;
            temp /=10;
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

        public String next(){

            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine(){
            String str="";

            try {
                str= br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }


    }
}

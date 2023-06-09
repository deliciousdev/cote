package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class P06Q1120 {

    static FastReader sc = new FastReader();
    static String A;
    static String B;


    public static void main(String[] args) {

        A = sc.next();
        B = sc.next();

        int minDifference = Integer.MAX_VALUE;

        int rightShift=0;
        int i=B.length()-A.length()+1;
        while (i-- > 0) {
           int difference=calcDifference(rightShift++);
            minDifference = Math.min(minDifference, difference);
        }

        System.out.println(minDifference);
    }

    static int calcDifference(int rightShiftCnt){
        int cnt=0;

        for(int i=0; i<A.length(); ++i){
            int BIndex=i+rightShiftCnt;
            if (A.charAt(i) != B.charAt(BIndex)) {
                ++cnt;
            }
        }
        return cnt;
    }


    static class FastReader{

        BufferedReader br;
        StringTokenizer tk;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while (tk == null || !tk.hasMoreElements()) {
                try {
                    tk = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return tk.nextToken();
        }

        String nextLine(){

            String str="";

            try{
                str= br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

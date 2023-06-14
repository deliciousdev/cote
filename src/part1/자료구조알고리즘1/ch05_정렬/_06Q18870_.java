package part1.자료구조알고리즘1.ch05_정렬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _06Q18870_ {


    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] seq;
    static int[] inputs;
    static Map<Integer,Integer> pressedPoints;

    public static void main(String[] args){

        init();
        Arrays.sort(inputs);

        int current=Integer.MIN_VALUE;
        int point =0;

        for(int i=0; i<inputs.length; ++i){
            if(current==inputs[i]) continue;

            current=inputs[i];
            pressedPoints.put(current,point++);
        }

        for(int i=0; i<seq.length; ++i){
            int pressedPoint = pressedPoints.get(seq[i]);
            sb.append(pressedPoint).append(" ");
        }
        System.out.print(sb.toString());
    }

    static void init(){
        N= sc.nextInt();
        seq= new int[N];
        inputs= new int[N];
        pressedPoints= new HashMap();

        for(int i=0; i<N; ++i){
            seq[i] = sc.nextInt();
            inputs[i] = seq[i];
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){

            while(st==null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

package part1.자료구조알고리즘1.ch05_정렬;

import java.util.*;
import java.io.*;

/**
 * 중복되는 input 그대로 있는 상태로 빈도수 대로 정렬 할려면, 같은 빈도 일때 먼저 나온것에 대한 데이터가 필요 하기 때문에 이 방법은 별로임.
 */
public class _07Q2910 {

    static FastReader sc = new FastReader();
    static int N,C;
    static Integer[] inputs;
    static Map<Integer,Integer> cntMap;
    public static void main(String[] args){
        init();

        Integer cntTemp=0;
        for(int i=0; i<N; ++i){
            int input=sc.nextInt();
            inputs[i]=input;
            cntTemp = cntMap.get(input);
            if(cntTemp==null){
                cntMap.put(input,1);
            }
            else{
                cntMap.put(input,cntTemp+1);
            }
        }

        Arrays.sort(inputs,new MyComparator(cntMap));

        print();
    }

    static class MyComparator implements Comparator<Integer>{

        Map<Integer,Integer> cntMap;

        public MyComparator(Map<Integer,Integer> cntMap){
            this.cntMap = cntMap;
        }

        @Override
        public int compare(Integer i1, Integer i2){

            if(i1.equals(i2)){
               return 0;
            }



            return -1*(cntMap.get(i1)-cntMap.get(i2));
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<inputs.length; ++i){
            sb.append(inputs[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
    static void init(){
        N= sc.nextInt();
        C= sc.nextInt();
        inputs= new Integer[N];
        cntMap = new HashMap();
    }
    static class FastReader{

        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){

            while(st==null || !st.hasMoreElements()){
                try{
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

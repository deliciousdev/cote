package part1.자료구조알고리즘1.ch05_정렬;

import java.util.*;
import java.io.*;

/**
 * dp
 */
public class P02Q18310 {

    static int N;
    static Integer[] placePosition;
    static Map<Integer,Integer> cntMap;
    static int[] delta ;

    public static void main(String[] args){
        init();

        Arrays.sort(placePosition,0,cntMap.size());

        int leftSide=0;
        int mnDeltaIndex=0;
        int placePositionLength = cntMap.size();
        for(int i=0; i<=placePositionLength-2; ++i){
            int currentCnt=cntMap.get(placePosition[i]);
            int d = placePosition[i+1]- placePosition[i];
            int temp = 2*d*leftSide + 2 *d * currentCnt-d*N;
            delta[i+1]=delta[i]+temp;
            if(delta[mnDeltaIndex]>delta[i+1]){
                mnDeltaIndex=i+1;
            }

            leftSide +=currentCnt;
        }

        System.out.print(placePosition[mnDeltaIndex]);
    }

    static void init() {
        FastReader sc = new FastReader();
        N= sc.nextInt();
        cntMap= new HashMap();
        placePosition= new Integer[N];

        int index=0;
        for(int i=0; i<N; ++i){
            int temp =sc.nextInt();
            Integer cnt = cntMap.get(temp);

            if(cnt==null){
                cntMap.put(temp,1);
                placePosition[index++]=temp;
            }
            else{
                cntMap.put(temp,cnt+1);
            }
        }

        delta = new int[cntMap.size()];
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null|| !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str ="";
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

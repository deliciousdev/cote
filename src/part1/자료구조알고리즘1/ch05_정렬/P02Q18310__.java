package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Map 으로 빈도수 같은거 자료구조 만들고, 중복 제외한 원소들 배열로 뽑을때
 */
public class P02Q18310__ {

    static int N;
    static Integer[] placePosition;
    static Map<Integer,Integer> cntMap;
    static int[] delta ;

    public static void main(String[] args){
        init();

        Arrays.sort(placePosition);

        int leftSide=0;
        int mnDeltaIndex=0;
        for(int i=0; i<=placePosition.length-2; ++i){
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

        for(int i=0; i<N; ++i){
            int temp =sc.nextInt();
            cntMap.merge(temp,1,Integer::sum);
        }

        delta = new int[cntMap.size()];
        placePosition = cntMap.keySet().toArray(new Integer[0]);
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

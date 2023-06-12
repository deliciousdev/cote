package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P02Q18310_ {

    static int N;
    static Integer[] placePosition;
    static Map<Integer,Integer> cntMap;
    static int[] delta ;

    public static void main(String[] args){
        init();

//        Arrays.sort(placePosition,0,cntMap.size());
        Arrays.sort(placePosition);//이렇게 하면 초기값으로 들어있던 뒤에 0들 때문에 아래에서 제대로 동작안함.( 널포인터 Exception)

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

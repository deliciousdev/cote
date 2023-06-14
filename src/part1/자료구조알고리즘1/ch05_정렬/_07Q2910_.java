package part1.자료구조알고리즘1.ch05_정렬;

import java.io.*;
import java.util.*;

/**
 * 1. 중복이 제거되어있는 배열을 빈도수대로 정렬 한후, 빈도수 대로 다시 복원 시키기
 * 2. 중복되는 데이터를 그대로 받는데, 첫번째 나타난 인덱스를 기록하여, 정렬할때 빈도수와 첫번째 나타난 인덱스를 반영하기
 * 3. 입력을 받는 original 배열을 두고, original배열을 카피한 배열을 정렬 하여 압축 좌표를 구한다.  보존되어있던 origianl 배열을 통해 원래 순서에 맞는 압축좌표를 출력.
 */
public class _07Q2910_ {

    static FastReader sc = new FastReader();
    static int N,C;
    static Integer[] inputs;
    static Map<Integer,Integer> cntMap;
    public static void main(String[] args){
        init();

        Integer cntTemp=0;
        int inputsLength=0;
        for(int i=0; i<N; ++i){
            int input=sc.nextInt();
            cntTemp = cntMap.get(input);
            if(cntTemp==null){
                inputs[inputsLength++]=input;
                cntMap.put(input,1);
            }
            else{
                cntMap.put(input,cntTemp+1);
            }
        }

        Arrays.sort(inputs, 0, inputsLength, new MyComparator(cntMap));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inputsLength; ++i){
            int temp = cntMap.get(inputs[i]);
            while(temp-->0){
                sb.append(inputs[i]).append(" ");
            }
        }

        System.out.print(sb.toString());
    }

    static class MyComparator implements Comparator<Integer>{

        Map<Integer,Integer> cntMap;
        MyComparator(Map<Integer,Integer> cntMap){
            this.cntMap = cntMap;
        }

        @Override
        public int compare(Integer i1, Integer i2){
            return -1*(cntMap.get(i1)-cntMap.get(i2));
        }
    }

    static void init(){
        N= sc.nextInt();
        C= sc.nextInt();
        inputs = new Integer[N];
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

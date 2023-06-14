package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 나는 중복을 제거 해준후 정렬을 했는데,
 * 중복이 있는상태에서 정렬을 하면 중복되는것들이 모여지므로 중복을 제외해주기 더 편리함. : 출력 : 시간단축이 엄청됨.
 * 정렬이 된상태에서 중복되는것을 제외하면서 출력
 */
public class _02Q1181_ {

    static FastReader sc = new FastReader();
    static int N;

    public static void main(String[] args) {
        N= sc.nextInt();

//        solve1();
//        solve2();
        solve3();

    }

    //396ms : 정렬, 중복되는 데이터 제거 : TreeSet 이용
    static void solve1(){
        Set<String> inputs = new TreeSet(new MyComparator());
        for(int i=0; i<N; ++i){// L* O( LogN ) * N개
            inputs.add(sc.next());
        }
        String[] strings = inputs.toArray(new String[0]);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strings.length; ++i){
            sb.append(strings[i]).append("\n");
        }

        System.out.print(sb.toString());
    }


    //392ms : 입력을 다 받은후 정렬하면 데이터가 그룹화됨. 그룹화된 데이터를 O(N) 으로 탐색하면서 중복 데이터를 없앨수 있음 : L * O(NlogN)
    static void solve2(){
        String[] inputs = new String[N];

        for(int i=0; i<N; ++i){
            inputs[i] = sc.next();
        }
        Arrays.sort(inputs,new MyComparator()); //

        StringBuilder sb = new StringBuilder();
        sb.append(inputs[0]).append("\n");
        for(int i=0; i<=inputs.length-2; ++i){
            if(inputs[i].equals(inputs[i+1])) continue;

            sb.append(inputs[i+1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    //1788ms : 데이터가 중복인지 아닌지 확인하면서 데이터를 넣는경우
    static void solve3(){
        List<String> inputs = new ArrayList();

        for(int i=0; i<N; ++i){
            String input = sc.next();
            if(inputs.contains(input)) continue; //

            inputs.add(input);
        }
        inputs.sort(new MyComparator());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inputs.size(); ++i){
            sb.append(inputs.get(i)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {

            if (o1.length()!=o2.length()){
                return Integer.compare(o1.length(),o2.length());//길이에 대해서 오름차순
            }
            return o1.compareTo(o2); //사전순 : String 을 사전순으로 비교할려면 String 전체를 탐새 해야함. 이 부분대문에 전체 시간 복잡도 : L * NlogN
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){

            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";

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

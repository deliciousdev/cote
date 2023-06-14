package part1.자료구조알고리즘1.ch05_정렬;


import java.io.*;
import java.util.*;

/**
 * @여러 사람이 있고 , 중복되는 데이터들이 흩어 져있을때 정렬로 그룹화 해줄수도 있었는데,
 * @이런 경우 Set 을이용하여 그룹화 효과를 줄 수 있음.
 * @강의에서 list 와, set 시간복잡도 등 다시 확인
 */
//https://www.acmicpc.net/source/61939085
public class _04Q7785___ {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Set<String> presentPeople;


    public static void main(String[] args) {
        init();

        int n= N;
        while(n-->0){
            String name = sc.next();
            String log = sc.next();

            if(log.startsWith("e")){
                presentPeople.add(name);
            }
            else{
                presentPeople.remove(name);
            }
        }

        print();

    }

    static void print(){
        String[] names = presentPeople.toArray(new String[0]);
        for(int i=0; i<names.length; ++i){
            sb.append(names[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void init() {
        N = sc.nextInt();
        presentPeople = new TreeSet(new MyComparator());
    }

    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String s1, String s2){
//            return -1*(CharSequence.compare(s1,s2));
            return -1*(s1.compareTo(s2));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

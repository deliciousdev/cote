package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _02Q1181 {

    static FastReader sc = new FastReader();
    static int N;
    static List<String> arr;

    public static void main(String[] args) {
        init();

        arr.sort(new MyComparator());

        print();
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (o1.length()!=o2.length()){
                return o1.length() - o2.length();//길이에 대해서 오름차순
            }
            return o1.compareTo(o2); //사전순
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); ++i){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void init(){
        N = sc.nextInt();
        arr = new ArrayList<>();


        for(int i=0; i<N; ++i){
            String temp = sc.next();
            if(arr.contains(temp)) continue;

            arr.add(temp);
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

package part1.자료구조알고리즘1.ch05_정렬;

import java.io.*;
import java.util.*;


/**
 * Comparator 의 Arg 로 배열이 들어오는경우 ( 근데 그냥 클래스 만들어서하는게 일반적이고 좋음 ㅋ)
 * 2차원 배열이라는것이 1차원 배열에서 각 칸마다 배열들이 있는것으로 논리적으로 생각하면 되는듯
 */

public class _03Q10814_ {


    static FastReader sc = new FastReader();
    static int N;

    static String[][] arr;


    public static void main(String[] args) {
        init();

        Arrays.sort(arr,new MyComparator());

        print();


    }

    static void init(){
        N= sc.nextInt();
        arr= new String[N][2];

        for(int i=0; i<N; ++i){
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; ++i){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class MyComparator implements Comparator<String[]> {

        @Override
        public int compare(String[] arr1, String[] arr2){
            int age1 = Integer.parseInt(arr1[0]);
            int age2 = Integer.parseInt(arr2[0]);

            return age1-age2; //나이 오름차순
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

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

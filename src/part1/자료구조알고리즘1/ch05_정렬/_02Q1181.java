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
public class _02Q1181 {

    static FastReader sc = new FastReader();
    static int N;
    static List<String> arr;
    static String[] arr2;

    public static void main(String[] args) {
//        init();
        init2();

//        arr.sort(new MyComparator());
        Arrays.sort(arr2,new MyComparator()); //Comparator 안넣어주면 기본으로 사전순

//        print();
//        print2();
        print3();
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (o1.length()!=o2.length()){
                return o1.length() - o2.length();//길이에 대해서 오름차순
            }
            return o1.compareTo(o2); //사전순 : String 을 사전순으로 비교할려면 String 전체를 탐새 해야함. 이 부분대문에 전체 시간 복잡도 : L * NlogN
        }
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); ++i){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void print2(){
        StringBuilder sb = new StringBuilder();
        String current = arr2[0];
        sb.append(current).append("\n");
        for(int i=1; i<arr2.length; ++i){
            if(current.equals(arr2[i])) continue;

            current=arr2[i];
            sb.append(current).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void print3(){ //정렬후 중복 제거하면서 출력 하는 코드
        StringBuilder sb = new StringBuilder();
        sb.append(arr2[0]).append("\n");
        for(int i=1; i<arr2.length; ++i){
            if(!arr2[i].equals(arr2[i-1])) {
                sb.append(arr2[i]).append("\n");
            }
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
    static void init2(){
        N= sc.nextInt();
        arr2= new String[N];
        for(int i=0; i<N; ++i){
            arr2[i]=sc.next();
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

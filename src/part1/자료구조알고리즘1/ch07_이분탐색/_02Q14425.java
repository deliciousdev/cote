package part1.자료구조알고리즘1.ch07_이분탐색;


import java.util.*;
import java.io.*;

/**
 * 여러번 탐색이 필요할땐 바이너리서치를 꼭 생각하자
 * 이진탐색 하는데 결과가 잘 안나오면 print로 left, right, mid ,target을 찍어서 확인해보자
 * Object 타입에 관해서도 Arrays.binarySearch() 가능
 */

public class _02Q14425 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int cnt;
    static String[] strings;

    public static void main(String[] args) {

//        solve1();//binarySearch : 516ms
        solve2();//Set : 504ms
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        strings= new String[N];
        for(int i=0; i<N; ++i){
            strings[i]= sc.next();
        }
        Arrays.sort(strings);

        int m= M;
        while(m-->0){
//            int idx= binarySearch(strings, sc.next()); //516 ms
            int idx= Arrays.binarySearch(strings,sc.next()); //468 ms 로 제일 짧긴함
            if(idx>=0){
                ++cnt;
            }
        }
        System.out.print(cnt);
    }

    static void solve2(){
        N= sc.nextInt();
        M= sc.nextInt();

        Set strings = new HashSet();

        int n= N;
        while(n-->0){
            strings.add(sc.next());
        }

        int m=M;
        int cnt=0;
        while(m-->0){
            if(strings.contains(sc.next())){
                ++cnt;
            }
        }
        System.out.print(cnt);
    }

    static int binarySearch(String[] strings,String target){
        int left=0;
        int right= strings.length-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(strings[mid].compareTo(target)>0){ //중복되는 코드는 따로 변수로 받은후 사용하자
                right=mid-1;
            }
            else if(strings[mid].compareTo(target)<0){
                left=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
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
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
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

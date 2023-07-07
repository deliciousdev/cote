package part5.단기완성알고리즘._03이분탐색;

import java.util.*;
import java.io.*;

/**
 * cnt 가 int 로 감당가능한지도 따져봐야함
 * n^2 탐색 으로는 시간초과이므로 이것을 줄여야함 -> 바이너리서치를 사용하자
 * 총 복잡도 : MlogM + NlogM : 정렬 + 이분탐색
 * 전형적인 답 코드를 보고 이분탐색 그냥 외우자..(갱신하는 코드)
 */
public class _01Q7795 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int T;
    static int N,M;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        T= sc.nextInt();

        int t= T;
        while (t-- > 0) {
            N= sc.nextInt();
            M= sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];

            for(int i=0; i<A.length; ++i){
                A[i]=sc.nextInt();
            }
            for(int i=0; i<B.length; ++i){
                B[i]=sc.nextInt();
            }
            int cnt= binarySearch(A,B);
            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    static int binarySearch(int[] A, int[] B){
        Arrays.sort(B);

        int cnt=0;
        for(int i=0; i<A.length; ++i) {

            int left= 0;
            int right=B.length-1;
            int target= A[i];
            while (left <= right) {
                int mid = (left + right) / 2;

                if(B[mid]>target){
                    right=mid-1;
                }
                else if(B[mid]<target){
                    left= mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            int lowerBound=right;
            cnt+=lowerBound+1;
        }

        return cnt;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str= "";
            try{
                str=br.readLine();
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

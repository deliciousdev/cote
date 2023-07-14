package part5.단기완성알고리즘._04투포인터;


/**
 * 투포인터의 힌트.
 * -1차원 배열에서의 연속 부분수열  or 순서를 지키며 차례대로  <<이런 키워드
 * -곱의최소 <<이런 키워드 ( 두수의 곱이 작아질려면, 하나의 피연산자가 작아질때 다른 피연산자는 커져야함)
 * 이런 단어가 등장하면 투포인터 접근을 시도해 볼 가치가 있다.
 *
 * 문제속 키워드 : "연속된 수들"의 부분합
 *
 * 가장 쉬운 풀이 : N^2 : L을 고정시키고 부분합이 S를 넘길때까지 R을 증가시킴 : 이것을 L에 대해서 반복함
 *
 * 이문제에서 투포인터 포인트 : p2가 증가 하다가 sum 을 넘기는 순간 p1를 증가 시키는데, p1가 증가할때 p2는 그냥 그자리에서 시작해도됨(p2 이전꺼는 볼필요도 없음).
 *
 * p1 도 최대 N번 이동, p2도 최대 N번 이동 : 총 시간 복잡도 : 2N -> O(N)
 */

import java.util.*;
import java.io.*;

public class _01Q1806 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;

    public static void main(String[] args) {
//        solve1(); //길이를 줄일때는 먼저 sum 을구하고 p1을 키워야함 , 길이를 늘릴때는 p2를 키우고 sum 을 구함 , while 문 조건 디테일, while 다 끝나고 while 로 한번 더 처리해줘야함
//        solve2(); //누적합
        solve3();//모범답안
    }

    static void solve3(){
        N= sc.nextInt();
        S= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        int p1=0;
        int p2=0;
        int l=1;
        int ans=Integer.MAX_VALUE;

        int sum= arr[0];
        for(p1=0; p1<arr.length; ++p1){

            while(sum<S && p2+1<arr.length){
                ++p2;
                ++l;
                sum+=arr[p2];
            }

            if(sum>=S){
                ans=Math.min(ans,l);
            }

            sum-=arr[p1];
            --l;
        }

        System.out.print(ans!=Integer.MAX_VALUE?ans:0);
    }
    static void solve2() {
        N = sc.nextInt();
        S = sc.nextInt();
        int[] acc= new int[N+1];
        for(int i=1; i<=N; ++i){
            acc[i]= acc[i-1]+sc.nextInt();
        }

        int p1=1;
        int p2=1;
        int l =1;
        int ans= Integer.MAX_VALUE;

        while(p1<=p2 &&p2<=N){
            int sum= acc[p2]-acc[p1-1];
            if(sum<S){
                ++p2;
                ++l;
            }
            else{
                ans= Math.min(ans,l);
                ++p1;
                --l;
            }
        }
        System.out.print(ans!=Integer.MAX_VALUE?ans:0);
    }

    static void solve1() {
        N = sc.nextInt();
        S = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];

        int l = 1;
        int ans = Integer.MAX_VALUE;

        while (p2+1 <= arr.length - 1 && p1 <= p2) {

            if (sum < S) {
                ++p2;
                ++l;
                sum += arr[p2];
            } else {
                ans = Math.min(ans, l);

                sum -= arr[p1];
                ++p1;
                --l;

            }
        }
        while (sum >= S && p1 <= p2) {
            ans = Math.min(ans, l);

            --l;
            sum -= arr[p1];
            ++p1;
        }
        System.out.print(ans!=Integer.MAX_VALUE?ans:0);
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

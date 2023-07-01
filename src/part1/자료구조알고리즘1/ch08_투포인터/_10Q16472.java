package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

/**
 * 투포인터의 핵심 : [i+1:j] 는 [i:j] 보다 무조건 알파벳 종류가 같거나 적기 때문에  i:j에서 알파벳 검사를 하고나면 i+1:j 에서는 안해도됨
 *
 * 누적합,이진탐색으로도 풀 수 있음 : 알파벳종류개수는 증가 함수 이기 때문에 이진 탐색 가능
 */
public class _10Q16472 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) {

        solve1(); //투포인터
//        solve2(); //브루트포스, 누적합 -> 시간초과
        //solve3(); //solve1() 에서 Map 을 사용하여 cnt 를 관리했던것을 배열로 해보자 : 배열로 빈도를 관리하고, 알파벳 종류 개수도 같이 관리해보자

    }

    static void solve1() {
        N = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        Map<Character, Integer> map = new HashMap();

        int left = 0;
        int right = -1;

        int ans = 0;
        while (right <= arr.length- 2) {
            char nextChar = arr[right + 1];
            if (map.get(nextChar) == null && map.size() == N) {
                Integer cnt = map.get(arr[left]);
                if (cnt-1 == 0) {
                    map.remove(arr[left]);
                }
                else{
                    map.put(arr[left],cnt-1);
                }
                ++left;
            } else {
                ++right;
                map.merge(arr[right], 1, Integer::sum);
            }

            ans = Math.max(ans, right - left + 1);
        }
        System.out.print(ans);
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

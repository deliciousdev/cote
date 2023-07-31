package test;

import java.util.*;
import java.io.*;

/**
 * 범위를 보고 bfs는 절대 안된다라는것을 알아야함
 */
public class P1011 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    static void solve2(){

        int T= sc.nextInt();

        while(T-->0){
            int ans=0;
            int x= sc.nextInt();
            int y= sc.nextInt();
            int distance= y-x;

            int rootFloor= (int) Math.sqrt(distance-1);

            if(distance<=rootFloor*rootFloor+rootFloor){
                ans=2*rootFloor;
            }
            else{
                ans= 2*rootFloor+1;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve1() {
        int T = sc.nextInt();
        while (T-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int ans = bfs(x, y);
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int bfs(int start, int dest) {

//        boolean[] visited = new boolean[(1 << 31) - 1];

        Queue<Integer> q = new LinkedList<>();
//        visited[start] = true;

        int currentCnt = 1;
        int previousRange = 1;
        int currentPosition = start + previousRange;

//        visited[currentPosition] = true;
        q.add(currentCnt);
        q.add(currentPosition);
        q.add(previousRange);


        while (!q.isEmpty()) {
            currentCnt = q.poll();
            currentPosition = q.poll();
            previousRange = q.poll();
            for (int i = 0; i < 3; ++i) {
                int nextRange = getNextRange(previousRange, i);
                int nextPosition = currentPosition + nextRange;
                int nextCnt = currentCnt + 1;

                if (nextPosition < 0 || nextPosition > (1 << 31) - 1) continue;
                if (nextPosition == dest && nextRange == 1) {
                    return nextCnt;
                }
//                if (visited[nextPosition]) continue;

//                visited[nextPosition] = true;
                q.add(nextCnt);
                q.add(nextPosition);
                q.add(nextRange);

            }

        }

        return -1;
    }

    static int getNextRange(int previousRange, int i) {
        if (i == 0) return previousRange - 1;
        if (i == 1) return previousRange;
        return previousRange + 1;
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

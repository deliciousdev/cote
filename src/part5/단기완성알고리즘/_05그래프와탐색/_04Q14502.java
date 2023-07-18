package part5.단기완성알고리즘._05그래프와탐색;

import java.util.*;
import java.io.*;


/**
 * MultiSource BFS : 초기 바이러스들의 좌표를 전부 Q에 넣고 Q를 돌린다.
 * 2차원 좌표를 Q에 넣을때 구조체를 이용하지 않고 Integer 를 2개씩 넣고, 2개씩 빼면됨.
 * visit 대신 0 인 칸을 2로 바꿔줘도됨.
 * MultiSource BFS 로 하면 바이러스가 이미 지나가서 2로 바뀐곳을 Q에 넣지 않아서 더 효율적임
 */
public class _04Q14502 {


    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] map;
    static int[][] copyMap;

    static int virusCnt;
    static int wallCnt;

    static int minVirus = Integer.MAX_VALUE;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                int temp = sc.nextInt();
                map[i][j] = temp;
                if (temp == 2) ++virusCnt;
                else if (temp == 1) ++wallCnt;
            }
        }

        for (int i = 0; i < N * M; ++i) {
            for (int j = i + 1; j < N * M; ++j) {
                for (int k = j + 1; k < N * M; ++k) {

                    int[] pointer = {i, j, k};
                    if (!isAllEmptySpace(pointer)) continue; //미리 EmptySpace 들의 좌표 데이터 구조를 갖고 거기서 3개를 뽑아도됨.
//                    copyMap = map.clone(); //clone() 하면 포인터만 그냥 복사되는거라서 copyMap을 변경하면 Map도 같이 변경됨
                    int[][] copyMap=copyOf(map);
                    setWall(pointer, copyMap);

                    bfs(copyMap);
                }
            }
        }

        int ans = M * N - minVirus - (wallCnt + 3);
        System.out.print(ans);

    }

    static int[][] copyOf(int[][] arr){
        int[][] copy = new int[arr.length][0];
        for(int i=0; i<arr.length; ++i){
            copy[i]=new int[arr[i].length];
        }
        for(int i=0; i<arr.length; ++i){
            for(int j=0; j<arr[i].length; ++j){
                copy[i][j]=arr[i][j];
            }
        }
        return copy;
    }
    static boolean isAllEmptySpace(int[] pointer) {

        for (int i = 0; i < 3; ++i) {
            int row = pointer[i] / M;
            int col = pointer[i] % M;
            if (map[row][col] != 0) return false;
        }
        return true;
    }

    static void bfs(int[][] copyMap) {

        int cnt = virusCnt;
        Queue<Point> q = new LinkedList();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (copyMap[i][j] != 2) continue;

                q.add(new Point(i, j)); //MultiSourceBFS 가 아니면 이미 바이러스가 지나가서 2가 된곳이 Q에 들어 갈수도 있긴함
                while (!q.isEmpty()) {
                    Point current = q.poll();
                    for (int k = 0; k < 4; ++k) {
                        int nextRow = current.row + d[k][0];
                        int nextCol = current.col + d[k][1];

                        if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > M - 1) continue;
                        if (copyMap[nextRow][nextCol] == 0) {
                            copyMap[nextRow][nextCol] = 2;
                            q.add(new Point(nextRow,nextCol)); //넣어주는게 맞음 안넣어 주면 이중포문의 진행방향에서 이미 지나간곳에 대해서 탐색을 진행할 수 없음
                            ++cnt;
                        }
                    }
                }

            }
        }

        minVirus = Math.min(minVirus, cnt);
    }

    static void setWall(int[] pointer, int[][] copyMap) {

        for (int i = 0; i < 3; ++i) {
            int row = pointer[i] / M;
            int col = pointer[i] % M;
            copyMap[row][col] = 1;
        }

    }

    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
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

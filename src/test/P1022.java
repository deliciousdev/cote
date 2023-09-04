package test;

import java.util.*;
import java.io.*;

/**
 * 평행이동, 인덱스 범위 , 소용돌이 구현 등..
 * while(number<=length*length) 까지 안하고 map이 다 채워졌으면 루프 종료 해도되긴함.(4개의 꼭지점이 채워지면끝)
 */
public class P1022 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int r1, c1, r2, c2;
    static String[][] map;
    static int[][] d = {//위,왼,아래,오
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    static int r1Trans, r2Trans, c1Trans, c2Trans;


    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {

        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        int trans = 5000;
        r1Trans = r1 + trans;
        r2Trans = r2 + trans;
        c1Trans = c1 + trans;
        c2Trans = c2 + trans;

        map = new String[r2 - r1 +1][c2 - c1 + 1];

        int row = trans ;
        int col =  trans;
        int number = 1;
        if (isInSpace(row, col)) {
            map[row-trans-r1][col-trans-c1] = String.valueOf(number);
        }
        ++number;
        //여기까지 1번 좌표

        int cnt = 1;
        int length= 2*trans+1;
        while(number<=length*length) {
            ++col;//오른쪽 한번
            if (isInSpace(row, col)) {
                map[row-trans-r1][col-trans-c1] = String.valueOf(number);
            }
            ++number;

            int temp = cnt * 2 - 1;
            while (temp-- > 0) {//위쪽이동
                row = row + d[0][0];
                col = col + d[0][1];
                if (isInSpace(row, col)) {
                    map[row-trans-r1][col-trans-c1] = String.valueOf(number);
                }
                ++number;
            }

            for (int i = 1; i <= 3; ++i) {
                temp = cnt * 2;
                while (temp-- > 0) {//왼쪽,아래,오른쪽
                    row = row + d[i][0];
                    col = col + d[i][1];
                    if (isInSpace(row, col)) {
                        map[row-trans-r1][col-trans-c1] = String.valueOf(number);
                    }
                    ++number;
                }
            }

            if(mapIsAllFilled()) break;
            ++cnt;
        }
        print();
    }

    static boolean mapIsAllFilled(){
        int colLast= map[0].length-1;
        int rowLast=map.length-1;
        return map[0][0]!=null &&map[0][colLast]!=null && map[rowLast][0]!=null && map[rowLast][colLast]!=null;
    }
    static boolean isInSpace(int row, int col) {
        return r1Trans <=row && row<= r2Trans && c1Trans <=col && col<= c2Trans;
    }

    static void print() {
        int mxL = findMxL();

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                int temp=mxL-map[i][j].length();
                while(temp-->0){
                    sb.append(" ");
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int findMxL() {
        int mxL=-1;
        for(int i=0; i<map.length; ++i){
            for(int j=0; j<map[i].length; ++j){
                mxL= Math.max(mxL,map[i][j].length());
            }
        }
        return mxL;
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

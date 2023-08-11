package test;

import java.util.*;
import java.io.*;

/**
 * 시간복잡도 줄이는것이 관건이니까 투포인터 를 사용하는것이 관건임
 * 투포인터 알고리즘에서 인덱스예외 안나게 잘 꼼꼼하게 해줘야함
 */
public class P1092 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] limit;
    static int[] box;
    static int[] lowerBoundIdx;
    static int[] craneIdx;
    static boolean[] done;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        N = sc.nextInt();
        limit = new int[N];
        for (int i = 0; i < N; ++i) {
            limit[i] = sc.nextInt();
        }
        M = sc.nextInt();
        box = new int[M];

        for (int i = 0; i < M; ++i) {
            box[i] = sc.nextInt();
        }

        done = new boolean[M];
        lowerBoundIdx = new int[limit.length];

        craneIdx= new int[N];
        Arrays.fill(craneIdx,box.length-1);

        Arrays.sort(limit);
        Arrays.sort(box);

//        calcLowerBoundIdx();

        if (limit[limit.length - 1] < box[box.length - 1]) {
            System.out.print(-1);
            System.exit(0);
        }

//        int ans = work();//시간초과
        int ans=work2();
        System.out.print(ans);
    }

    static int work() {//시간 복잡도 계산 안하고 그냥 짯었음. O(N M M)

        int remain = box.length;
        int time=0;
        while (remain > 0) {
            ++time;
            for (int i = limit.length - 1; i >= 0; --i) {
                for (int j = box.length - 1; j >= 0; --j) {
                    if (!done[j] && limit[i] >= box[j]) {
                        done[j] = true;
                        --remain;
                        break;
                    }
                }
            }
        }
        return time;
    }

    static int work2(){ //O(N M)


        int remain=box.length;
        int time=0;
        while(remain>0){
            ++time;
            for(int i=limit.length-1; i>=0; --i){
                int j= craneIdx[i];
                while(j>=0 && (done[j] || limit[i]<box[j])){
                    j = --craneIdx[i];
                }
                if(j<0) continue;

                done[j]=true;
                --remain;
            }
        }
        return time;
    }

    static void calcLowerBoundIdx() {

        int idx = 0;
        int temp = -1;
        for (int i = 0; i < box.length; ++i) {
            if (limit[idx] >= box[i]) {
                temp = i;
            } else {
                lowerBoundIdx[idx++] = temp;
                --i;
            }
        }
        while (idx < lowerBoundIdx.length) {
            lowerBoundIdx[idx++] = box.length - 1;
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

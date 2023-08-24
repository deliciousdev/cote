package test;

import java.util.*;
import java.io.*;

/**
 * 이런 배치 문제류 는 대부분 그리디 인듯..?
 * 모든 과제들을 데드라인쪽으로 땡겨서 배치해야함 : 데드라인이 작은거 부터 배치한다고하면, 어느 정도로 데드라인쪽으로 당기느냐에 따라 추후에 배치할것들에 대해서 영향을 미침
 * -> 데드라인이 큰거부터 배치해야겠다고 접근함.
 */
public class P1263 {

    static FastReader sc = new FastReader();

    static int n;

    static Task[] tasks;

    public static void main(String[] args) {
        solve1();
//        solve2();//틀린 풀이
    }

    static void solve2() {
        n = sc.nextInt();
        tasks = new Task[n];
        for (int i = 0; i < tasks.length; ++i) {
            tasks[i] = new Task(sc.nextInt(), sc.nextInt());
        }

        //데드라인이 가장 늦은게 제일 앞으로
        Arrays.sort(tasks, (t1, t2) -> {
            return Integer.compare(t1.deadLine, t2.deadLine) * -1;
        });

        int availableTime = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; ++i) {
            availableTime = Math.min(availableTime, tasks[i].deadLine);
            if (availableTime <= 0) {
                System.out.print(-1);
                System.exit(0);
            }
            availableTime -= tasks[i].requiredTime;
        }
        System.out.print(availableTime);
    }

    static void solve1() {
        n = sc.nextInt();
        tasks = new Task[n];
        for (int i = 0; i < tasks.length; ++i) {
            tasks[i] = new Task(sc.nextInt(), sc.nextInt());
        }

        //데드라인이 가장 늦은게 제일 앞으로
        Arrays.sort(tasks, (t1, t2) -> {
            return Integer.compare(t1.deadLine, t2.deadLine) * -1;
        });

        int availableTime = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; ++i) {
            availableTime = Math.min(availableTime, tasks[i].deadLine);
            availableTime -= tasks[i].requiredTime;
            if (availableTime < 0) {
                System.out.print(-1);
                System.exit(0);
            }
        }
        System.out.print(availableTime);
    }

    static class Task {
        int requiredTime;
        int deadLine;

        Task(int requiredTime, int deadLine) {
            this.requiredTime = requiredTime;
            this.deadLine = deadLine;
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

package test;


import java.util.*;
import java.io.*;


/**
 * 분할 정복, 재귀
 * int 일때 (a-b)/2 + b == (a+b)/2 인듯?
 */
public class P1030 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int s, n, k, r1, r2, c1, c2;
    static final int BLACK = 1;
    static final int WHITE = 0;

    public static void main(String[] args) {
        s = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        r1 = sc.nextInt();
        r2 = sc.nextInt();
        c1 = sc.nextInt();
        c2 = sc.nextInt();

        if(s==0){
            System.out.print(0);
            System.exit(0);
        }

        solve1();
    }

    static void solve1() {

        int length=(int) Math.pow(n, s);
        for(int i=r1; i<=r2; ++i){
            for(int j=c1; j<=c2; ++j){
                sb.append(validateColor(i,j,length));
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static int validateColor(int r, int c, int L) {//초기 length : pow(n,s)

        if(L==1) return WHITE;

        int d = L / n;
        if ((n - k) / 2 * d <= r && r < ((n - k) / 2 + k) * d
        && (n - k) / 2 * d <= c && c < ((n - k) / 2 + k) * d) {
            return BLACK;
        }

        //다음 단계에서 어느 사각형에 들어가는게 중요한게 아니라 들어간후 어디 위치인지가 중요함
        // : division 연산자가 아닌 remainder 연산자
        return validateColor(r%d,c%d,d);
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

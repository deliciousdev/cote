package part1.자료구조알고리즘1.ch04완전탐색_시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class _02Q10448 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int T;
    static int K;
    static boolean find;

    public static void main(String[] args) {
        T = sc.nextInt();

//        solve1();
//        solve2();
//        solve3();
        solve4();
        System.out.println(sb.toString());

    }

    public static void solve1() { //K 범위를 44까지줄일 수 있는데 그렇지 못했음.
        while (T-- > 0) {
            K = sc.nextInt();
            find = false;
            Loop1:
            for (int i1 = 1; i1 < K; ++i1) {
                for (int i2 = i1; i2 < K; ++i2) {
                    for (int i3 = i2; i3 < K; ++i3) {
                        if (sum(i1, i2, i3) == K) {
                            find = true;
                            break Loop1;
                        }
                    }
                }
            }
            sb.append(find ? 1 : 0).append("\n");
        }
    }

    public static void solve2() { // sum 구하는것이 중복 되는 것이기 때문에 배열을 만들어 놓고, 최초에만 계산하해서 저장해놓고, 이후에는 가져다 쓰면 되는데 그러지 못함
        while (T-- > 0) {
            K = sc.nextInt();
            find = false;
            Loop1:
            for (int i1 = 1; i1 < K; ++i1) { //K는 44까지임. -> 시간복잡도 O(44^3)
                if(sum(i1)>1000) break; //K는 44까지임. -> 시간복잡도 O(44^3)
                for (int i2 = i1; i2 < K; ++i2) {
                    if(sum(i2)>1000)break;
                    for (int i3 = i2; i3 < K; ++i3) {
                        if(sum(i3)>1000)break;
                        if (sum(i1, i2, i3) == K) {
                            find = true;
                            break Loop1;
                        }
                    }
                }
            }
            sb.append(find ? 1 : 0).append("\n");
        }
    }

    public static void solve3(){//메모리제이션 이용

        int[] arr= new int[50];

        while(T-->0){
            K = sc.nextInt();
            find= false;
            Loop1:
            for(int i1 = 1; getArr(i1,arr)<K ;++i1){
                for(int i2= 1; getArr(i2,arr)<K; ++i2){
                    for(int i3= 1; getArr(i3,arr)<K; ++i3){
                        if( getArr(i1,arr)+getArr(i2,arr)+getArr(i3,arr)==K){ //K가 똑같은것이 나온다면, 전체 로직을 불필요하게 반복 하게 되는것임
                            find = true;
                            break Loop1;
                        }
                    }
                }
            }
            sb.append(find ? 1 : 0).append("\n");
        }
    }



    public static void solve4(){//메모리제이션 이용

        int[] arr= new int[50];
        int[] isEureka = new int[1001];

        while(T-->0){
            K = sc.nextInt();

            if(isEureka[K]==0){ //결국 이것도 3중 포문이 반복되는 구조이므로, 전처리로 3중포문을 한번 싹 돌려서 isEureka[] 를 표시해두는것이 더 효율적
                isEureka[K]=-1;
                Loop1:
                for(int i1 = 1; getArr(i1,arr)<K ;++i1){
                    for(int i2= 1; getArr(i2,arr)<K; ++i2){
                        for(int i3= 1; getArr(i3,arr)<K; ++i3){
                            if( getArr(i1,arr)+getArr(i2,arr)+getArr(i3,arr)==K){
                                isEureka[K]=1;
                                break Loop1;
                            }
                        }
                    }
                }
            }

            sb.append(isEureka[K]==1 ? 1 : 0).append("\n");
        }
    }

    public static int getArr(int i,int[] arr){
        if(arr[i] != 0){
            return arr[i];
        }
        return arr[i]= i*(i+1)/2;
    }





    public static int sum(int a, int b, int c) {
        return a * (a + 1) / 2 + b * (b + 1) / 2 + c * (c + 1) / 2;
    }
    public static int sum(int a){
        return a*(a+1)/2;
    }

    static class FastReader {
        BufferedReader br;

        BufferedWriter bw;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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

        void write(String source) throws IOException { //BufferedWriter 보다 StringBuilder 가 더 빠르다고 하는것 같음
            bw.write(source);
//            bw.flush();
        }
        //flush 는 write 를 여러번 하고 나중에 한번만 해주면됨
        //write 은 기본적으로 String or int 를 받기 때문에 개행문자는 스트링으로해줘야함
    }

}

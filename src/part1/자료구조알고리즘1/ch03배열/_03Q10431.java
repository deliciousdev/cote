package part1.자료구조알고리즘1.ch03배열;

import java.io.*;
import java.util.StringTokenizer;


//원래는 답의 범위도 고려해서 N이 커졌을때 답의 최대값이 int 범위를 넘는지도 확인했어야함.

public class _03Q10431 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int p; //테스트케이스수
    static int T; //케이스번호
    static int N=20;
    static int[] arr= new int[N];
    static int ans;
    public static void main(String[] args) {

        p = sc.nextInt();

        for(int i=1; i<=p ; ++i){
            ans=0;
            sc.nextInt();

//            solve1();
            solve2();

            sb.append(i).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void solve1() {
        for(int j=0; j<N; ++j){//학생 입장

            int temp = sc.nextInt();
            arr[j]= temp;
            for(int k=0; k<j; ++k){//자기보다 키큰애를 찾음
                if (temp <arr[k]) { //한칸씩 밀기
                    for (int z = j-1; z>=k ; --z){
                        arr[z+1]=arr[z];
                        ++ans;
                    }
                    arr[k]=temp;
                    break;
                }//이 부분은 인덱스를 저장해두고 현재 for 밖에서 병렬적으로 처리 해도 상관없음. -> 시간 복잡도 n^3이 아니라 n^2 이 맞음
            }
        }
    }

    public static void solve2(){
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }
        for(int i=1; i<N; ++i){
            for(int j=0; j<i; ++j){//앞에 있는애들 탐색
                if(arr[j]>arr[i]){
                    ++ans;
                }
            }
        }
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

        void write(String source) throws IOException {
            bw.write(source);
            bw.flush();
        }
    }
}

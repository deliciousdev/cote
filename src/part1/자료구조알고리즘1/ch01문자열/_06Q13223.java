package part1.자료구조알고리즘1.ch01문자열;

import java.io.*;
import java.util.StringTokenizer;

public class _06Q13223 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String current;
    static String target;

    public static void main(String[] args) {
        input();
        solve();

        System.out.println(sb.toString());

    }

    public static void input() {
        current = sc.next();
        target = sc.next();
    }

    public static void solve() {
        int convertedCurrent = parseAndConvertToSecond2(current);
        int convertedTarget = parseAndConvertToSecond2(target);

        if( convertedTarget<=convertedCurrent){
            convertedTarget += 24*60*60;
        }

        int delta = convertedTarget - convertedCurrent;

        String second = String.valueOf(delta % 60);
        delta /=60;
        String minute = String.valueOf(delta % 60);

        String hour = String.valueOf(delta / 60);

//        second = format(second);
//        minute = format(minute);
//        hour = format(hour);
//
//        sb.append(hour).append(":").append(minute).append(":").append(second);


        int s =Integer.parseInt(second);
        int m = Integer.parseInt(minute);
        int h =Integer.parseInt(hour);
        sb.append(String.format("%02d:%02d:%02d", h, m, s));
    }

    //String 은 call by value 로 동작함
    private static void processFormatting(String second, String minute, String hour) {
        if(second.length()==1){
            second = "0" + second;
        }
        if(minute.length()==1){
            minute = "0" + minute;
        }
        if(hour.length()==1){
            hour = "0" + hour;
        }
    }

    private static String format(String time) {
        if (time.length() < 2) {
            time = "0" + time;
        }
        return time;
    }

    public static int parseAndConvertToSecond(String time){

        String[] timeElements = time.split(":");
        int hour = Integer.parseInt(timeElements[0]);
        int minute = Integer.parseInt(timeElements[1]);
        int second = Integer.parseInt(timeElements[2]);

        return hour * 60 * 60 + minute * 60 + second ;
    }
    public static int parseAndConvertToSecond2(String time){

        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        int second = Integer.parseInt(time.substring(6,8));

        return hour * 60 * 60 + minute * 60 + second ;
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

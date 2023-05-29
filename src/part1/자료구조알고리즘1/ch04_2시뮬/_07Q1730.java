package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _07Q1730 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static char[] commands = new char[250];
    static char[][] map;
    static char[] commandBuffer = new char[2];
    static int currentRow = 0;
    static int currentCol = 0;

    static Map<Character, Integer> commandHash = new HashMap<>();

    public static void main(String[] args) {

        init();

        int bufferIndex = 0;
        for (int i = 0; i < commands.length; ++i) {
            if (!validateCommand(currentRow, currentCol, commands[i])) continue;

            commandBuffer[bufferIndex++ % 2] = commands[i];
            writeOnMap();
            move(commands[i]);
        }

        if (commandBuffer[0] + commandBuffer[1] != 0 && map[currentRow][currentCol] != 43) {//'+' 아닐때 , 모든 명령이 무시 됐을때를 고려해줘야함
            map[currentRow][currentCol] = getIcon(commandBuffer[(bufferIndex - 1) % 2]);
        }

        print();

    }

    private static void print() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static char getIcon(char command) {
        char result;
        switch (command) {
            case 'D':
            case 'U':
                result = 124;
                break;

            default:
                result = 45;

        }
        return result;
    }

    public static void init() {
        commandHash.put('D', 1);
        commandHash.put('U', 2);
        commandHash.put('L', -1);
        commandHash.put('R', -2);

        N = sc.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                map[i][j] = '.';
            }
        }
        commands = sc.next().toCharArray();
    }

    public static boolean validateCommand(int currentRow, int currentCol, char command) {
        if (command == 'D') {
            currentRow++;
        } else if (command == 'U') {
            currentRow--;
        } else if (command == 'L') {
            currentCol--;
        } else {//R
            currentCol++;
        }
        return 0 <= currentRow && currentRow < N && 0 <= currentCol && currentCol < N;
    }

    public static void writeOnMap() {
        //+일때
        if (map[currentRow][currentCol] == 43) return;

        Integer c1 = commandHash.get(commandBuffer[0]);
        Integer c2 = commandHash.get(commandBuffer[1]);
        char result;
        if (map[currentRow][currentCol] == 46) {//.


            if (c1 == null || c2 == null) {
                if (c1 != null) {
                    result = getIcon(commandBuffer[0]);
                } else if (c2 != null) {
                    result = getIcon(commandBuffer[1]);
                } else {
                    return;
                }
                map[currentRow][currentCol] = result;
                return;
            }


            if (c1 * c2 < 0) {// (U,D) x (L,R)
                result = 43;
            } else {
                if (c1 + c2 > 0) { //U x U , D x D , U x D
                    result = 124;
                } else { // L x L , R x R , L x R
                    result = 45;
                }
            }
            map[currentRow][currentCol] = result;
            return;
        } else if (map[currentRow][currentCol] == 124) {//|
            if(c1==null && c2 ==null) return ;
            if (c1 != null && c1 < 0 || c2 != null && c2 < 0) {
                map[currentRow][currentCol] = '+';
            }
        } else if (map[currentRow][currentCol] == 45) {//-
            if(c1==null && c2 ==null) return ;
            if (c1 != null && c1 > 0 || c2 != null && c2 > 0) {
                map[currentRow][currentCol] = '+';
            }
        }

    }

    public static void move(char command) {
        if (command == 'D') {
            currentRow++;
        } else if (command == 'U') {
            currentRow--;
        } else if (command == 'L') {
            currentCol--;
        } else {//R
            currentCol++;
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

        void write(String source) throws IOException { //BufferedWriter 보다 StringBuilder 가 더 빠르다고 하는것 같음
            bw.write(source);
//            bw.flush();
        }
        //flush 는 write 를 여러번 하고 나중에 한번만 해주면됨
        //write 은 기본적으로 String or int 를 받기 때문에 개행문자는 스트링으로해줘야함
    }
}

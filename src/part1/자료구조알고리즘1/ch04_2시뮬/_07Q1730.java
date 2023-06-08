package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 이문제 입력 받을때 nextLine()이 아니라 next()를 하면 런타임 에러뜸 : next()는 입력이 아무것도 없을때는 받아 들이지 않으므로. 문제 에서 조건으로 아무입력이 없을때도 있음.
 * next()를 써야하는데 입력이 안들어 올수도 있을때는
 * sc.hasNext()? sc.next(): ""; 이런식으로 할수 있음
 */
public class _07Q1730 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N;
    static char[] commands;
    static char[][] board;
    static Point position = new Point();

    public static void main(String[] args) {
        input();

        for (int i = 0; i < commands.length; ++i) {
            char command = commands[i];
            if (!validateCommand(command)) continue;

            writeOnBoard(command);
            position.move(command);
            writeOnBoard(command);
        }

        print();
    }

    static void print() {

        for(int i=0; i< board.length; ++i){
            for(int j=0; j<board[i].length; ++j){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void input() {
        N = sc.nextInt();
        board = new char[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                board[i][j] = '.';
            }
        }
        commands = sc.nextLine().toCharArray();
    }
    static void writeOnBoard(char command){

        char boardState = board[position.row][position.col];

        if (boardState == '.') {
            switch (command) {
                case 'U':
                case 'D': board[position.row][position.col]= '|'; break;
                case 'R':
                case 'L' : board[position.row][position.col]='-'; break;
                default:
            }
        }
        else if (boardState == '|') {
            switch (command) {
                case 'R':
                case 'L' : board[position.row][position.col]='+'; break;
                default:
            }
        }
        else if( boardState=='-'){
            switch (command){
                case 'U':
                case 'D': board[position.row][position.col]='+'; break;
                default:
            }
        }
        else{//+

        }
    }
    static boolean validateCommand(char command) {
        int nextCol = 0;
        int nextRow = 0;
        switch (command) {
            case 'U':
                nextRow = position.row - 1;
                break;
            case 'D':
                nextRow = position.row + 1;
                break;
            case 'R':
                nextCol = position.col + 1;
                break;
            case 'L':
                nextCol = position.col - 1;
                break;
            default:
        }
        return nextCol >= 0 && nextCol < N && nextRow >= 0 && nextRow < N;
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

        String next() { //공백 까지 문자열 (입력이 없다면 : 입력이 공백이라면 런타임에러발생)
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

        String nextLine() {//공백 포함 개행이 나올때까지 한줄의 문자열
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

    static class Point {
        int row;
        int col;

        public Point() {
            row = 0;
            col = 0;
        }


        void move(char command) {
            switch (command) {
                case 'U':
                    --row;
                    break;
                case 'D':
                    ++row;
                    break;
                case 'L':
                    --col;
                    break;
                case 'R':
                    ++col;
                    break;
                default:
            }
        }

    }
}

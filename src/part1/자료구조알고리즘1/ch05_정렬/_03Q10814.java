package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Comparator 의 arg 로 배열도 들어 올 수 있음
 */
public class _03Q10814 {


    static FastReader sc = new FastReader();
    static int N;
    static User[] users;

    public static void main(String[] args) {
        init();

        Arrays.sort(users);

        print();
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< users.length; ++i){
            sb.append(users[i].age).append(" ").append(users[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void init(){

        N = sc.nextInt();
        users= new User[N];
        for(int i=0; i< users.length; ++i){
            users[i] = new User(sc.nextInt(), sc.next());
        }
    }

    static class User implements Comparable<User> {

        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            if(this.age==o.age){ //굳이 안해도됨. 아래로직에서 포함되어있음
                return 0;
            }
//            return Integer.compare(this.age, o.age);
            return Integer.valueOf(this.age).compareTo(o.age);
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

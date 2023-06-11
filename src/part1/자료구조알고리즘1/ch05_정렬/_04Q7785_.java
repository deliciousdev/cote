package part1.자료구조알고리즘1.ch05_정렬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @여러 사람이 있고 , 중복되는 데이터들이 흩어 져있을때 정렬로 그룹화 해줄수도 있었는데,
 * @이런 경우 Set 을이용하여 그룹화 효과를 줄 수 있음.
 * @강의에서 list 와, set 시간복잡도 등 다시 확인
 */
//https://www.acmicpc.net/source/61939085
public class _04Q7785_ {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static final int ENTER = 1;
    static final int LEAVE = -1;
    static Log[] logs;


    public static void main(String[] args){
        init();

        Arrays.sort(logs);

        print();
    }

    static void init(){
        N= sc.nextInt();
        logs = new Log[N+1];
        for(int i=0; i<N; ++i){
            logs[i] = new Log(sc.next(),sc.next());
        }
        Log dummy = new Log("0","leave");
        logs[N]= dummy;
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            if(!logs[i].name.equals(logs[i+1].name) && logs[i].log==ENTER){
                sb.append(logs[i].name).append("\n");
            }
        }
        System.out.print(sb.toString());

    }
    static class Log implements Comparable<Log>{


        String name;
        int log;

        public Log(String name, String log){
            this.name= name;
            this.log = log.startsWith("e")?ENTER:LEAVE;
        }

        @Override
        public int compareTo(Log o){//사전 역순 정렬
            return -1*(this.name.compareTo(o.name));
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str="";
            try{
                str= br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

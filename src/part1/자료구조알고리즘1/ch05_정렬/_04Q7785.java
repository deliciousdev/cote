package part1.자료구조알고리즘1.ch05_정렬;


import java.util.*;
import java.io.*;

/**
 * 런타임에서 int 에 null 넣으면 NullPointerException 터짐
 *
 * 흩어져있는 자료들을 탐색해야할때, 정렬을 하면 그룹으로 묶은후 탐색 할 수 잇음.
 */
//https://www.acmicpc.net/source/61939085
public class _04Q7785 {

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

        static final Map<String, Integer> convertMap ;

        static{
            convertMap = new HashMap();
            convertMap.put("enter",1);
            convertMap.put("leave",-1);
        }

        public Log(String name, String log){
            this.name = name;
            this. log = convertMap.get(log); //this.log 가 int 타입 일때 convertMap.get() 이 Null 뱉으면 널포인터예외터짐
        }
        String name;
        Integer log; //이거 int 이면 널포인터 예외 가능성 있음

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

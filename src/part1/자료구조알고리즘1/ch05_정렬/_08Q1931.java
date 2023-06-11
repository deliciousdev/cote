package part1.자료구조알고리즘1.ch05_정렬;

import java.util.*;
import java.io.*;

/**
 * 다른사람들은 다 그리디로 했네, 나는 dp 로함
 */
public class _08Q1931 {

    static FastReader sc = new FastReader();

    static int N;
    static int[] table;
    static Meeting[] meetings;

    public static void main(String[] args){
        init();

        Arrays.sort(meetings);


        int tableIndex=0;
        for(int i=0;i<meetings.length; ++i){
            int start= meetings[i].start;
            int end = meetings[i].end;
            if(end==0) continue;

            while(tableIndex+1<=end){
                table[tableIndex+1]=table[tableIndex];
                ++tableIndex;
            }
            table[end]=Math.max(table[end-1],table[start]+1);
            tableIndex=end;
        }

        System.out.print(table[table.length-1]);
    }

    static void init(){
        N= sc.nextInt();
        meetings = new Meeting[N];

        int mxEnd=Integer.MIN_VALUE;
        int endAtZeroCnt=0;
        for(int i=0; i<N; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            if(end==0){
                ++endAtZeroCnt;
            }

            mxEnd=Math.max(mxEnd,end);
            meetings[i] = new Meeting(start,end);
        }

        table= new int[mxEnd+1];
        table[0]=endAtZeroCnt;
    }

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o){
            if(this.end==o.end){
                return Integer.compare(this.start,o.start); //시작 하고 끝이 같은경우는 정렬후 그룹에서 맨 뒤에 와야됨.
            }
            return Integer.compare(this.end,o.end);
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

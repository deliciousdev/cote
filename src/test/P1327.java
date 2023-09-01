package test;

import java.util.*;
import java.io.*;

/**
 * 모든 경우의수가 언제 까지 인지 계산으로알수 없음.
 * 실제로 시뮬레이션을 통해서 결과를 해봐야 알 수 있음.
 * visited 이 어떤 위치 값이 아니고 어떤 연산의 결과임.
 */
public class P1327 {

    static FastReader sc= new FastReader();
    static int n,k;
    static Set<String> set=new HashSet<>();

    public static void main(String[] args){
        solve1();
    }

    static void solve1() {
        n= sc.nextInt();
        k= sc.nextInt();
        String input=sc.nextLine().replace(" ","");
        char[] input_= input.toCharArray();
        Arrays.sort(input_);
        String target= String.valueOf(input_);
        if(input.equals(target)){
            System.out.print(0);
            System.exit(0);
        }

        int ans=bruteForceByBfs(input,target);
        System.out.print(ans);
    }

    static int bruteForceByBfs(String startString,String target){


        Queue<Data> q = new LinkedList();
        Data start= new Data(startString,0);
        q.add(start);
        set.add(startString);
        while(!q.isEmpty()){
            Data d= q.poll();
            String s=d.s;
            int cnt= d.cnt;

            for(int pickIdx=0; pickIdx+k-1<s.length(); ++pickIdx){
                String flippedString = flip(s,pickIdx,pickIdx+k-1);
                if(set.contains(flippedString)) continue;

                if(flippedString.equals(target)) return cnt+1;

                set.add(flippedString);
                q.add(new Data(flippedString,cnt+1));
            }
        }

        return -1;
    }


    static String flip(String s, int begin, int end){
        String pre = s.substring(0,begin);
        String flip = s.substring(begin,end+1);
        String suf = s.substring(end+1);
        StringBuilder sb =new StringBuilder(flip);
        sb.reverse();
        sb.insert(0,pre);
        sb.append(suf);
        return sb.toString();
    }
    static class Data{
        String s;
        int cnt;
        Data(String s, int cnt){
            this.s= s;
            this.cnt=cnt;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
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

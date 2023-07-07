package part5.단기완성알고리즘._02정렬;

import java.util.*;
import java.io.*;

public class _04P20291 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;

    public static void main(String[] args){
//        solve1(); //정렬을 이용한 카운팅 : . 로 split 할때 escape 처리를 해줘야하네...?
        solve2(); //Map을 이용한 카운팅
    }

    static void solve1(){
        N= sc.nextInt();
        String[] files= new String[N];
        for(int i=0; i<N; ++i){
            files[i]= sc.next().split("\\.")[1];
        }
        Arrays.sort(files);

        String current=files[0];
        int cnt=0;
        for(int i=0; i<N; ++i){
            if(current.equals(files[i])){
                ++cnt;
            }
            else{
                sb.append(current).append(" ").append(cnt).append("\n");
                cnt=1;
                current=files[i];
            }
        }
        sb.append(current).append(" ").append(cnt);

        System.out.print(sb.toString().trim());
    }

    static void solve2(){
        N=sc.nextInt();
        Map<String,Integer> map = new TreeMap();

        for(int i=0; i<N; ++i){
            map.merge(sc.next().split("\\.")[1],1,Integer::sum);
        }

        for(String key : map.keySet()){
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
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
        String nextLIne(){
            String str = "";
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

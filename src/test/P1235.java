package test;

import java.util.*;
import java.io.*;

/**
 * 단순 구현
 * set 에 중복이 있어서 추가안되면 false 리턴, 추가 되면 true 리턴
 */
public class P1235 {

    static FastReader sc= new FastReader();
    static int n;
    static String[] ids;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        ids= new String[n];
        for(int i=0; i<ids.length; ++i){
            ids[i]=sc.next();
        }

        Set<String> set= new HashSet<>();
        int ans=-1;
        for(int k=1; k<=100; ++k){
            for(int i=0; i<ids.length; ++i){
                String sub= ids[i].substring(ids[i].length()-k);
                if(!set.add(sub)){
                    set.clear();
                    break;
                }
            }
            if(set.size()==ids.length){
                ans=k;
                break;
            }
        }
        System.out.print(ans);
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

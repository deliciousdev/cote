package test;

import java.util.*;
import java.io.*;

/**
 * 구현 ,브루트포스
 * 두 배열이 미끌어져 가면서 교차
 */
public class P1195 {

    static FastReader sc= new FastReader();

    static char[] arr1;
    static char[] arr2;
    public static void main(String[] args){
        arr1=sc.next().toCharArray();
        arr2= sc.next().toCharArray();
        solve1();
    }

    static void solve1(){
        int L1=arr1.length;
        int L2=arr2.length;

        int ans=L1+L2;

        for(int i=1; i<=L1; ++i){
            boolean ok=true;
            int compatibleRange=0;
            int idx1=L1-i;
            int idx2=0;
            while(idx1<L1 && idx2<L2){
                if(!validate(arr1[idx1],arr2[idx2])) {
                    ok=false;
                    break;
                }
                ++compatibleRange;
                ++idx1;
                ++idx2;
            }
            if(ok) {
                int range = L1 + L2 - compatibleRange;
                ans = Math.min(ans, range);
            }
        }
        for(int i=1; i<=L2-1; ++i){
            boolean ok=true;
            int compatibleRange=0;
            int idx1=0;
            int idx2=i;
            while(idx1<L1&&idx2<L2){
                if(!validate(arr1[idx1],arr2[idx2])) {
                    ok=false;
                    break;
                }
                ++compatibleRange;
                ++idx1;
                ++idx2;
            }
            if(ok){
                int range=L1+L2-compatibleRange;
                ans=Math.min(ans,range);
            }
        }

        System.out.print(ans);
    }

    static boolean validate(char e1, char e2){
        if(e1=='2'&&e2=='2') return false;
        return true;
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

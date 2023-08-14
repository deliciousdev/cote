package test;

import java.util.*;
import java.io.*;

/**
 * 특별한거 없음....
 */
public class P1101 {

    static FastReader sc= new FastReader();

    static int N,M;
    static int[][] arr;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        M=sc.nextInt();
        arr= new int[N][M];
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                arr[i][j]=sc.nextInt();
            }
        }


        ArrayList<Integer> singleColorBox = new ArrayList<>();
        ArrayList<Integer> emptyBox = new ArrayList<>();
        boolean[] checked = new boolean[M];
        for(int i=0; i<arr.length; ++i){
            int cnt=0;
            int color=-1;
            for(int j=0; j<arr[i].length; ++j){
                if(arr[i][j]!=0) {
                    ++cnt;
                    if(cnt==2) break;
                    color=j;
                }
            }
            if(cnt==0){
                emptyBox.add(i);
            }
            else if(cnt==1) {
                if(!checked[color]){
                    checked[color]=true;
                    singleColorBox.add(i);
                }
            }
        }

        int normalBox= N-singleColorBox.size()-emptyBox.size();
        int ans= normalBox>1? normalBox-1:0; //답이 그냥 normalBox 가 아니라 normalBox 가 1개 일때는 조커 필요 없어서 0 임
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

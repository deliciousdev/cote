package test;

import java.util.*;
import java.io.*;

/**
 * 그리디로 하면 안된다는것을 알아야함.
 * 냅색 냄새를 맡아야함. 냅색 초기값 꼼꼼하게 잘해줘야함( 적당히 큰수를 해줘야 오버플로우안남, dp[0]는 0으로 해줘야함)
 * 정석적인 냅색알고리즘은 최대값 구하는것이므로 dp를 0으로 초기화 해주면 됐는데 여기서는 min 값을 구해야하므로 오버플로우가 나지않을 적당히 큰값으로해줘야함
 */
public class P1229 {

    static FastReader sc= new FastReader();

    static int n;
    static int[] sixAngleNumbers= new int[1000];
    static int[] dp; //dp[i]: i를 만들수 있는 육각수 최소개수
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        setSixAngleNumbers();

        dp= new int[n+1];
        Arrays.fill(dp,7);
        dp[0]=0;
        for(int i=1; i<sixAngleNumbers.length && sixAngleNumbers[i]<=n; ++i){
            int num = sixAngleNumbers[i];
            for(int j=num; j<dp.length; ++j) {
                dp[j]=Math.min(dp[j],dp[j-num]+1);
            }
        }

        int ans=dp[n];
        System.out.print(ans);
    }


    static void setSixAngleNumbers(){
        sixAngleNumbers[1]=1;
        for(int i=2; i<sixAngleNumbers.length; ++i){
            sixAngleNumbers[i]=sixAngleNumbers[i-1] +(4*i-3);
        }
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

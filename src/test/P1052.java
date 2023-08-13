package test;

import java.util.*;
import java.io.*;


/**
 * 풀이 방법이 여러가지 있는데 나는 dp전처리로함 / 다른 풀이들 찾아보면 좋을듯
 */
public class P1052 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,K;

    static int[] arr=new int[1<<25]; //arr[i] : 물병 i일때 최대로 합치면 arr[i]개 까지 만들 수 있음

    public static void main(String[] args){
        solve1(); //440ms
//        solve2();//2020ms: dp를 전처리하지않고 필요한것만 구함 : 근데 시간 더 걸리네....
    }

    static void solve2(){
        N=sc.nextInt();
        K=sc.nextInt();

        if(K>=N){
            System.out.print(0);
            System.exit(0);
        }

        if(isPowOfTwo(N)){
            System.out.print(0);
            System.exit(0);
        }

        int cnt;
        for(cnt=0; N+cnt<arr.length; ++cnt){
            if(getArr(N+cnt)<=K){
                break;
            }
        }
        System.out.println(cnt);
    }

    static int getArr(int i){
        if(i==0) return 0;
        if(arr[i]!=0) return arr[i];

        if(isPowOfTwo(i)) return arr[i]=1;
        int underPow =calcUnderPowOfTwo(i);

        return getArr(underPow)+getArr(i-underPow);
    }

    public static void solve1(){
        N=sc.nextInt();
        K=sc.nextInt();

        if(K>=N){
            System.out.print(0);
            System.exit(0);
        }

        if(isPowOfTwo(N)){
            System.out.print(0);
            System.exit(0);
        }

        arr[1]=1;
        for(int i=2; i<arr.length; ++i){
            int pow= calcUnderPowOfTwo(i);
            if(pow==i){
                arr[i]=1;
            }
            else{
                arr[i]=arr[pow]+arr[i-pow];
            }
        }

        int cnt;
        for(cnt=0; N+cnt<arr.length; ++cnt){
            if(arr[N+cnt]<=K){
                break;
            }
        }
        System.out.println(cnt);
    }

    static boolean isPowOfTwo(int x){
        if(x==1) return true;

        for(int i=1; i<=30; ++i){
            int temp=1<<i;
            if(temp==x) return true;
            else if(temp>x) break;
        }
        return false;
    }

    static int calcUnderPowOfTwo(int x){
        for(int i=1; i<=30; ++i){
            int temp=1 <<i;
            if(temp> x){
                return temp>>1;
            }
        }
        return -1;
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
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

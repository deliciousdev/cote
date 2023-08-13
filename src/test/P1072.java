package test;

import java.util.*;
import java.io.*;

public class P1072 {

    static FastReader sc =new FastReader();

    static int x, y;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        x =sc.nextInt();
        y =sc.nextInt();
        if(x ==y){
            System.out.print(-1);
            System.exit(0);
        }

        int cnt=calcHighRateCnt();

        System.out.print(cnt);
    }

    static int calcHighRateCnt(){
        long z= 100L* y/x; //이것도 오버플로우 조심
        long targetRate=z+1;

        int cnt=-1;
        int left=1;
        int right=1000000000;
        while(left<=right){
            int mid=(left+right)/2;

            long rate= 100L*(long)(y+mid)/(x+mid); //100* 때문에 오버플로우 조심, 100L 을 곱하거나 중간 피연산자에 long 형변환 해줘야함
//            int rate= 100*(y+mid)/(x+mid);
            if(targetRate<=rate){
                cnt=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return cnt;
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

package test;

import java.util.*;
import java.io.*;

/**
 * 과정을 나누기 보다는, 결과를 기준으로 나눈다 (결과의 추상화)
 */
public class P1117 {

    static FastReader sc = new FastReader();
    static long w,h,f,c,x1,y1,x2,y2;

    public static void main(String[] args){
//        solve1();
        solve2(); //결과의 추상화
    }

    static void solve2(){
        w=sc.nextInt();
        h=sc.nextInt();
        f=sc.nextInt();
        c=sc.nextInt();
        x1=sc.nextInt();
        y1=sc.nextInt();
        x2=sc.nextInt();
        y2=sc.nextInt();

        long s1=-1;
        long s2=-1;

        int mid=(int)Math.min(f,w-f);
        if(x2<=mid){
            s1=(x2-x1)*(y2-y1);
            s2=0;
        }
        else if(x1>=mid){
            s1=0;
            s2=(x2-x1)*(y2-y1);
        }
        else{
            s1=(mid-x1)*(y2-y1);
            s2=(x2-mid)*(y2-y1);
        }
        long S= (2*s1+s2) *(c+1);
        long ans=w*h-S;
        System.out.print(ans);
    }

    static void solve1(){
        w=sc.nextInt();
        h=sc.nextInt();
        f=sc.nextInt();
        c=sc.nextInt();
        x1=sc.nextInt();
        y1=sc.nextInt();
        x2=sc.nextInt();
        y2=sc.nextInt();

        long s1=-1;
        long s2=-1;
        if(f==0 ||f==w){
            s1=0;
            s2=(x2-x1)*(y2-y1);
        }
        else if(f<(double)w/2){
            if(x1<f && x2<f){
                s1=(x2-x1)*(y2-y1);
                s2=0;
            }
            else if(x1>f && x2>f){
                s1=0;
                s2=(x2-x1)*(y2-y1);
            }
            else{
                s1=(f-x1)*(y2-y1);
                s2=(x2-f)*(y2-y1);
            }
        }
        else if(f>(double)w/2){
            if(x1<w-f&& x2<w-f){
                s1=(x2-x1)*(y2-y1);
                s2=0;
            }
            else if(x1>w-f&&x2>w-f){
                s1=0;
                s2=(x2-x1)*(y2-y1);
            }
            else{
                s1=(w-f-x1)*(y2-y1);
                s2=(x2-w+f)*(y2-y1);
            }
        }
        else{
            long S=2*(x2-x1)*(y2-y1)*(c+1);
            long ans=w*h-S;
            System.out.print(ans);
            System.exit(0);
        }

        long S= (2*s1+s2)*(c+1);
        long ans= w*h-S;
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

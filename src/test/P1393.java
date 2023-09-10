package test;

import java.util.*;
import java.io.*;

/**
 * 최대공약수 구할때 입력으로 0이 들어올 경우 고려해줘야함
 */
public class P1393 {

    static FastReader sc= new FastReader();
    static int targetX,targetY;
    static int currentX,currentY;
    static int dx,dy;
    public static void main(String[] args){
        targetX=sc.nextInt();
        targetY= sc.nextInt();
        currentX=sc.nextInt();
        currentY=sc.nextInt();
        dx=sc.nextInt();
        dy=sc.nextInt();

//        solve1(); //기차는 양쪽으로 이동하면안됨..
//        solve2(); //한방향으로만 이동하는 기차
        solve3();//gcd 깔끔하게
    }

    static void solve3(){

        int gcd=Gcd(dx,dy);
        int slopeDy=dy/gcd;
        int slopeDx=dx/gcd;

        int x= currentX;
        int y= currentY;
        int ansX=-500;
        int ansY=-500;
        int mnD=Integer.MAX_VALUE;
        while(-100<=x && x<=100 && -100<=y && y<=100){
            int d=calcDistanceSquare(x,y,targetX,targetY);
            if(mnD>d){
                mnD=d;
                ansX=x;
                ansY=y;
            }
            x+=slopeDx;
            y+=slopeDy;
        }

        System.out.print(ansX+" "+ansY);
    }

    static int Gcd(int a, int b){
        int mn = Math.min(a,b);
        int mx= Math.max(a,b);
        if(mn==0) return mx;
        if(mx%mn==0) return mn;
        return Gcd(mn,mx%mn);
    }

    static void solve2(){
        int slopeDy=dy;
        int slopeDx=dx;
        if(dx!=0 && dy!=0){
            int gcd=calcGcd(dx,dy);
            slopeDy=dy/gcd;
            slopeDx=dx/gcd;
        }
        else if(dx==0){
            slopeDy=1;
        }
        else{
            slopeDx=1;
        }

        int x= currentX;
        int y= currentY;
        int ansX=-500;
        int ansY=-500;
        int mnD=Integer.MAX_VALUE;
        while(-100<=x && x<=100 && -100<=y && y<=100){
            int d=calcDistanceSquare(x,y,targetX,targetY);
            if(mnD>d){
                mnD=d;
                ansX=x;
                ansY=y;
            }
            x+=slopeDx;
            y+=slopeDy;
        }

        System.out.print(ansX+" "+ansY);
    }


    static void solve1(){
        int slopeDy=dy;
        int slopeDx=dx;
        if(dx!=0 && dy!=0){
            int gcd=calcGcd(dx,dy);
            slopeDy=dy/gcd;
            slopeDx=dx/gcd;
        }
        else if(dx==0){
            slopeDy=1;
        }
        else{
            slopeDx=1;
        }

        int x= currentX;
        int y= currentY;
        int ansX=-500;
        int ansY=-500;
        int mnD=Integer.MAX_VALUE;
        while(x<=100 && y<=100){
            int d=calcDistanceSquare(x,y,targetX,targetY);
            if(mnD>d){
                mnD=d;
                ansX=x;
                ansY=y;
            }
            x+=slopeDx;
            y+=slopeDy;
        }

        x= currentX-slopeDx;
        y= currentY=slopeDy;
        while(-100<=x && -100<=y){
            int d= calcDistanceSquare(x,y,targetX,targetY);
            if(mnD>d){
                mnD=d;
                ansX=x;
                ansY=y;
            }
            x-=slopeDx;
            y-=slopeDy;
        }

        System.out.print(ansX+" "+ansY);
    }

    static int calcGcd(int a, int b){
        int mx= Math.max(a,b);
        int mn = Math.min(a,b);
        if(mn==0){

        }

        if(mx %mn==0) return mn;
        return calcGcd(mn,mx%mn);
    }

    static int calcDistanceSquare(int a, int b, int c, int d){
        return (a-c)*(a-c)+(b-d)*(b-d);
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

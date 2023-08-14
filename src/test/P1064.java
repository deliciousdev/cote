package test;

import java.util.*;
import java.io.*;


/**
 * 기울기가 같은지를 검사할 때 나눗셈을 사용하여 직접 기울기를 구하여 비교하면 두 점의 x좌표가 같을 경우 0으로 나누는 경우가 생깁니다.
 * 실수 타입은 0으로 나누어도 런타임에러가 발생하지 않고 무한대를 반환하기 때문에 의도하지 않은 결과가 나타날 수 있습니다.
 * 따라서 기울기가 같은지를 검사할 때 다른 방법을 사용해야 합니다.
 * 혹은 기울기가 같은지를 비교할때 b/a == y/x 를 비교하는 대신에 b*x == a*y 를 비교해도됨
 */
public class P1064 {

    static FastReader sc= new FastReader();
    static Point[] points;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){

        points= new Point[3];
        for(int i=0; i<points.length; ++i){
            points[i]=new Point(sc.nextInt(),sc.nextInt());
        }

//        if(!validate()){
//        if(!validate2()){
//            if(!validate3()){//맞는풀이
        if(!validate4()){//맞는풀이
            System.out.print(-1.0);
            System.exit(0);
        }

        double circumstance1 = calcCircumstance(0,1,2);
        double circumstance2= calcCircumstance(0,2,1);
        double circumstance3= calcCircumstance(1,2,0);

        double mx= Math.max(circumstance1,Math.max(circumstance2,circumstance3));
        double mn=Math.min(circumstance1,Math.min(circumstance2,circumstance3));

        double ans=mx-mn;
        System.out.print(ans);
    }

    static boolean validate4(){//기울기 비교를 할때 나누셈으로 하지않고 곱셈으로함
        Point p1=points[0];
        Point p2=points[1];
        Point p3= points[2];

        double dx1=p1.a-p2.a;
        double dy1=p1.b-p2.b;
        double dx2=p1.a-p3.a;
        double dy2=p1.b-p3.b;

        return dy1*dx2 != dx1*dy2;
    }
    static boolean validate3(){//기울기를 구할때 분모가 0인경우에 대해서 따로 처리를 해줌
        Point p1=points[0];
        Point p2=points[1];
        Point p3= points[2];
        if(p1.a==p2.a&& p1.a==p3.a) return false;

        double slope1= (double)(p1.b-p2.b)/(p1.a-p2.a);
        double slope2= (double)(p1.b-p3.b)/(p1.a-p3.a);
        return slope1!=slope2;
    }
    static boolean validate(){ //틀림
        Point p1=points[0];
        Point p2=points[1];
        Point p3= points[2];

        double slope1= (double)(p1.b-p2.b)/(p1.a-p2.a);
        double slope2= (double)(p1.b-p3.b)/(p1.a-p3.a);
        return slope1!=slope2;
    }

    static boolean validate2(){//틀림 : 0.9999999999999는 1이 아니기 때문에 오류 있음... : 기울기 비교할때 벡터 내적을 이용하는것은 안된다...
        Point p1=points[0];
        Point p2=points[1];
        Point p3= points[2];

        Point v1=new Point(p1.a-p2.a,p1.b-p2.b);
        Point v2= new Point(p1.a-p3.a,p1.b-p3.b);
        Point o=new Point(0,0);
        double cosTheta=(v1.a*v2.a+v1.b*v2.b)/(calcDistance(o,v1)*calcDistance(o,v2));
        return cosTheta!=1 && cosTheta!=-1;
    }

    static double calcCircumstance(int p1Idx, int p2Idx, int restPIdx){
        Point p1=points[p1Idx];
        Point p2= points[p2Idx];
        Point p3= points[restPIdx];

        Point p4 = calcAnotherP(p1,p2,p3);

        //p1-p3-p2-p4
        double d1= calcDistance(p1,p3);
        double d2= calcDistance(p3,p2);
        double d3=calcDistance(p2,p4);
        double d4= calcDistance(p4,p1);
        return d1+d2+d3+d4;

    }

    static double calcDistance(Point p1, Point p2){
        return Math.sqrt((p1.a-p2.a)*(p1.a-p2.a)+(p1.b-p2.b)*(p1.b-p2.b));
    }

    static Point calcAnotherP(Point p1, Point p2, Point p3){
        return new Point(p1.a+p2.a-p3.a,p1.b+p2.b-p3.b);
    }


    //근데 이렇게 하면 직각 으로 주어지면 틀리게됨..
    private static double getSlope(int[] p1, int[] p2) {
        if (p1[0] - p2[0] == 0) {
            return 0;
        }
        return (double) (p1[1] - p2[1]) / (p1[0] - p2[0]);
    }
    static class Point{
        int a;
        int b;
        Point(int a, int b){
            this.a=a;
            this.b=b;
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
                    st=new StringTokenizer(br.readLine());
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

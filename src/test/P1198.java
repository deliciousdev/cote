package test;

import java.util.*;
import java.io.*;


/**
 * 세점이 주어졌을때 신발끈 공식이 있네..??
 * 세변이 주어졌을때 헤론의 공식이 있네..??
 */
public class P1198 {

    static FastReader sc = new FastReader();

    static int n;
    static Point[] points;

    public static void main(String[] args) {
//        solve1();//벡터내적
        solve2();//신발끈공식...
    }

    static void solve2(){
        n= sc.nextInt();
        points= new Point[n];
        for(int i=0; i<n; ++i){
            points[i]=new Point(sc.nextInt(),sc.nextInt());
        }
        double ans=Double.MIN_VALUE;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                for(int k=j+1; k<n; ++k){
                    Point p1=points[i];
                    Point p2= points[j];
                    Point p3= points[k];

                    double s = calcTriangleSquareByShoelaceFormula(p1,p2,p3);
                    ans=Math.max(ans,s);
                }
            }
        }
        System.out.print(ans);
    }

    private static double calcTriangleSquareByShoelaceFormula(Point p1, Point p2, Point p3) {
        int x1= p1.x;
        int y1= p1.y;
        int x2= p2.x;
        int y2= p2.y;
        int x3= p3.x;
        int y3= p3.y;
        int temp = Math.abs((x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3));
        return 0.5* temp;
    }

    static void solve1() {
        n = sc.nextInt();
        points = new Point[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        double ans = Double.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    Point p1 = points[i];
                    Point p2 = points[j];
                    Point p3 = points[k];

                    Point v1 = makeVector(p1,p2);
                    Point v2 = makeVector(p1,p3);

                    double s = calcTriangleArea(v1, v2);
                    ans = Math.max(ans, s);
                }
            }
        }

        System.out.print(ans);
    }

    static Point makeVector(Point p1, Point p2){
       return new Point(p2.x-p1.x,p2.y-p1.y);
    }
    static double calcTriangleArea(Point p1, Point p2) {
        double p1LengthSquare = calcLengthSquare(p1);
        double p2LengthSquare = calcLengthSquare(p2);
        double vectorProduct = calcVectorProduct(p1, p2);

        double temp = p1LengthSquare* p2LengthSquare- vectorProduct * vectorProduct;
        return 0.5 * Math.sqrt(temp);
    }

    static double calcLengthSquare(Point p) {
        return p.x * p.x + p.y * p.y;
    }

    static int calcVectorProduct(Point p1, Point p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

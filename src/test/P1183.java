package test;

import java.util.*;
import java.io.*;

/**
 * 어떤 기준점에서 여러 점들까지의 거리를 구할때, 이 거리의 합이 최소값이 되게하는 기준점의 위치 :
 * 기준점을 오른쪽 왼쪽으로 움직일때 점이 많은 쪽으로 이동을 계속 하여야함 : 중앙값에 수렴
 */
public class P1183 {

    static FastReader sc= new FastReader();
    static int n;

    public static void main(String[] args){
        n=sc.nextInt();
//        solve1();//중근 위치 중근 고려 하면 잘못된 풀이임 : 절대값 그래프 개형으로 접근
//        solve2();//논리적으로 기준점을 왼쪽 or 오른쪽으로 이동했을때 어떤 지점으로 이동해야 최소값이 되는가를 논리적으로 생각해봄.
        solve3();//왼쪽인덱스부터 정답을 찾을때까지 오르쪽으로 이동하는것을 시뮬레이션
    }

    static void solve3(){
        int[] points = new int[n];
        for(int i=0; i<n; ++i){
            int a= sc.nextInt();
            int b= sc.nextInt();
            points[i]=b-a;
        }

        Arrays.sort(points);

        int idx=-1;
        int left=0;
        int right=n-left;

        int begin=-1;
        while(left<=right){
            ++idx;
            while( idx+1<n && points[idx]==points[idx+1]){
                ++idx;
            }
            left=idx+1;
            right=n-left;

            if(left<right){
                begin=idx;
            }
        }
        int end=idx;
        int beginValue=points[begin+1];
        int endValue=points[end];
        System.out.print(endValue-beginValue+1);

    }

    static void solve2(){
        int[] points = new int[n];
        for(int i=0; i<n; ++i){
            int a= sc.nextInt();
            int b= sc.nextInt();
            points[i]=b-a;
        }

        Arrays.sort(points);

        if(n%2==1){
            System.out.print(1);
            System.exit(0);
        }

        int begin= points[n/2-1];
        int end= points[n/2];
        System.out.print(end-begin+1);
    }

    static void solve1(){
        Set<Integer> set = new HashSet<>();
        while(n-->0){
            int a= sc.nextInt();
            int b= sc.nextInt();
            set.add(a-b);
        }

        if(set.size()%2==1){
            System.out.print(1);
            System.exit(0);
        }

        ArrayList<Integer> arr= new ArrayList(set);
        Collections.sort(arr);
        int L= arr.size();
        int begin=  arr.get(L/2-1);
        int end= arr.get(L/2);

        System.out.print(end-begin+1);
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

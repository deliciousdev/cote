package part1.자료구조알고리즘1.ch08_투포인터;


import java.util.*;
import java.io.*;

/**
 *  2003문제 : 작은거 부터 시작해서 큰거를 찾아가는 알고리즘 : p1 , p2 작은쪽에서 증가 하는 방향으로 움직임.
 *  2470문제 : 0과 가까운것을 찾는거기 때문에 양끝에서 가운데쪽으로 오는 방향으로 움직이게됨.
 *
 *  투포인터의 핵심 : 어떤 i, j 에대해서 최적을 찾으면 i+1 에서탐색을 할때는 j의 특정 부분을 탐색 안해도됨 -> 최적구간의 경계만 따라가면서 탐색하게됨(강의에서 그래프 그림)
 *  2003 , 2470 처럼 선형의 정렬되어있는 데이터 구조에서 범위를 확인하거나 쌍을 찾는 문제는 보통 투포인터, 이진탐색 둘다 적용 가능함
 *  1920,14425,2805,1654: 이진탐색으로 풀었던 문제들인데 투포인터로는 못푸는 문제임
 */
public class _02Q2470 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;


    public static void main(String[] args){
        solve1(); //424 ms : 투포인터
    }
    static void solve1(){
        N= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int p1=0; int p2=arr.length-1;
        int ans1 =-1;
        int ans2=-1;

        int optimalAbs = Integer.MAX_VALUE;
        while(p1<p2){
            int sum = arr[p1]+arr[p2];
            int sumAbs= Math.abs(sum);
            if(sumAbs<optimalAbs){
                optimalAbs= sumAbs;
                ans1=arr[p1];
                ans2=arr[p2];
            }
            if(sum<0){
                ++p1;
            }
            else if(sum>0){
                --p2;
            }
            else{
                break;
            }
        }
        System.out.print(ans1+" "+ans2);
    }

    static class FastReader{
        BufferedReader  br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
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
                str= br.readLine();
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

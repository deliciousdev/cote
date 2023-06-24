package part1.자료구조알고리즘1.ch07_이분탐색;


import java.util.*;
import java.io.*;

/**
 * 브루트포스 형식의 값을 정한다음 계산을 하는컨셉인데, 바이너리서치로 시도 횟수를 줄여줌.
 * 이런 문제는 헤갈리지 않게 그래프를 그리고 경계값을 기준으로 가능한지 가능 하지 않은지를 그리고 시작하는게 좋음.
 * 요것도 left right 해줄때 int 로 하면 오버 플로우발생
 * long mid=(left+right)/2; left+right 부분에서 오버플로우가 발생한다면 int mid = left +(right-left)/2; 로 해주면됨
 * 값이 존재 하지 않는 경우는 갱신하는 식으로 하는 방법이 편리할듯
 */
public class _08Q1654 {


    static FastReader sc = new FastReader();
    static StringBuilder sd = new StringBuilder();

    static int N,K;

    public static void main(String[] args){
        solve1();

    }
    static void solve1(){
        K= sc.nextInt();
        N= sc.nextInt();

        int[] arr= new int[K];
        for(int i=0; i<K; ++i){
            arr[i]=sc.nextInt();
        }

        long left=1;
        long right= Integer.MAX_VALUE;

        while(left<=right){
            long mid=(left+right)/2;
//            long mid = left +(right-left)/2; //위에랑 동치인데 오버플로우 방지 할 수 있음. 근데 이 문제 조건에서는 long 오버플로우가 발생할 여지는 없음

            int cnt= calcCnt(arr,(int)mid);
            if(cnt<N){
                right=mid-1;
            }
            else if(cnt>N){//요부분에서 ans를 갱신하는식으로 해도됨
                left=mid+1;
            }
            else{//요부분에서 ans를 갱신하는식으로 해도됨
                left=mid+1;
            }
        }
        System.out.print(right);
    }

    static int calcCnt(int[] arr,int mid){
        int cnt=0;
        for(int i=0; i<arr.length; ++i){
            cnt+= arr[i]/mid;
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
            String str= "";
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

package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

/**
 * 투포인터에서 시간복잡도 잘 따져보면 N제곱이 아니라 N + N 임.
 * p1 과 p2는 독립적 으로 움직임. 각각 0->N  0->N : (p1,p2) ==M 이 되는 경계값만 탐색하게됨
 * 결론적으로 Binary Search 는 NLog(N)  투포인터는 N임   근데 자바언어 에서 그렇게많이 차이나지는 않음
 * 강의 한번더 보는것이 좋을듯
 */
public class _01Q2003 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;

    public static void main(String[] args){
//        solve1();//176ms : 이진탐색 : 자연수가 아닌 음수를 포함한 수열이면 누적합이 증가 수열이 아니기 때문에 바이너리 서치 사용못함
//        solve2();//260ms : 부르트포스 : 2중 반복문 cf) 부르트포스 : 3중 반복문하고 비교해볼것
        solve3();//164ms : 투포인터 ,누적합
//        solve4();//160ms : 투포인터
//        solve5(); //시간초과 : 3중반복문
//        solve6(); //268ms : 부르트포스,누적합 : 2중 반복
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] acc = new int[N+1];
        for(int i=1; i<=N; ++i){
            acc[i]=acc[i-1]+sc.nextInt();
        }

        int cnt=0;
        for(int i=1; i<=N; ++i){

            int left=1;
            int right=N;

            while(left<=right){
                int mid = (left+right)/2;
                int sum = calcSum(acc,i,mid);
                if(sum<M){
                    left= mid+1;
                }
                else if(sum>M){
                    right=mid-1;
                }
                else{
                  ++cnt;
                  break;
                }
            }
        }
        System.out.print(cnt);
    }

    static void solve2(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] arr = new int[N];

        int cnt=0;
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<N; ++i){
            int sum=0;
            for(int j=i; j<N; ++j){
                sum+=arr[j];
                if(sum==M) ++cnt;
//                if(sum>M) break; //이것도 되긴함
                if(sum>=M) break;
            }
        }
        System.out.print(cnt);
    }
    static void solve5(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i]=sc.nextInt();
        }

        int cnt=0;
        for(int i=0; i<N; ++i){
            for(int j=i; j<N; ++j){
                int sum=0;
                for(int k=i; k<=j; ++k) {
                    sum+= arr[k];
                }
                if(sum==M) ++cnt;
                else if( sum>M) break; //요게 들어가는게 더 효율적임 but 최악의경우 시간복잡도는 같음.
            }
        }
        System.out.print(cnt);
    }

    static void solve6(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] acc = new int[N+1];
        for(int i=1; i<=N; ++i){
            acc[i]=acc[i-1]+sc.nextInt();
        }

        int sum=0;
        int cnt=0;
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=N; ++j){
                sum= acc[j]-acc[i-1];
                if(sum==M) ++cnt;
                if(sum>=M) break;
            }
        }
        System.out.print(cnt);
    }

    static void solve4(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        int cnt=0;
        int sum=0;
        int p2=0;
        for(int p1=0; p1<=N-1; ++p1){

            while(sum<M && p2<=N-1) { //강의에서는 sum 초기값을 arr[0] 으로하고 조건을 약간 다르게함
                sum+= arr[p2++];
            }
            if(sum==M){
                ++cnt;
            }
            sum-=arr[p1];
        }
        System.out.print(cnt);


    }
    static void solve3(){
        N=sc.nextInt();
        M= sc.nextInt();
        int[] acc= new int[N+1];//1~N
        for(int i=1; i<=N; ++i){
            acc[i]=acc[i-1]+sc.nextInt();
        }

        int p1=1;
        int p2=1;
        int cnt=0;
        while(p2<=N ){
            int sum =calcSum(acc,p1,p2);
            if(sum<M){
                ++p2;
            }
            else if(sum>M){
               ++p1;
//               if(p1>p2){ //이게 없어도 다음 반복문에서 if(sum<M)에 걸려서 ++p2가됨
//                   ++p2;
//                   p1=p2;
//               }
            }
            else{
                ++cnt;
                ++p1;
//                ++p2;//이것도 없어도 다음 반복문에서 if(sum<M) 에 걸려서 ++p2됨
            }
        }
        System.out.print(cnt);
    }
    static int calcSum(int[] acc, int from, int to){
        return acc[to]-acc[from-1];
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

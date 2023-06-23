package part1.자료구조알고리즘1.ch07_이분탐색;

import java.util.*;
import java.io.*;

/**
 * 가장 기본적인것은 Map으로 카운팅.
 * Map 안하고 메모리 괜찮으면 그냥 cnt배열 만들어서 cnt 해도됨. 그런데 음수가 포함된다면 모든 입력에 + 10 000 000 을 해준후 카운팅을하자.
 * LowerBound , UpperBound 개념
 * LowerBound : X이상의 값이 처음으로 나타나는 위치 (X의 맨왼쪽)
 * UpperBound : X초과의 값이 처음으로 나타나는 위치 (x의 맨오른쪽 에서 +1) : 기본적으로 정렬된 상태에서 적용되는 개념임.
 * UpperBound - LowerBound = X 의개수 : X가 존재하지않아도 적용됨 .
 * X가 존재하지않으면 lowerBound,upperBound 는 같은 곳을 가르키게됨. X보다 큰 첫번째수.
 *
 * Set 의 ceiling(), floor() 로도 풀수 있음.
 *
 * 강의에서는 UpperBound, LowerBound 구하는거 약간 달르긴함 참고해보셈.
 */
public class _05Q10816 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;

    public static void main(String[] args){
//        solve1();//1108ms : Map 이용
//        solve2(); //1576ms : BinarySearch 이용
        solve3();//1592ms : upperbound,lowerBound

    }

    static void solve1(){
        N=sc.nextInt();
        Map<Integer,Integer> map= new HashMap();
        int n=N;
        while(n-->0){
            int temp =sc.nextInt();
            map.merge(temp, 1, Integer::sum);
        }
        M=sc.nextInt();
        int m= M;
        while(m-->0){
            int temp = sc.nextInt();
            Integer cnt= map.get(temp);
            sb.append(cnt==null? 0:cnt).append(" ");
        }
        System.out.print(sb.toString());
    }

    static void solve2(){
        N= sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        M=sc.nextInt();

        int m=M;
        while (m-- > 0) {
            int temp= sc.nextInt();
            int cnt= count(arr,temp);
            sb.append(cnt).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    static void solve3(){
        N= sc.nextInt();
        int[] arr= new int[N];

        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        M= sc.nextInt();
        int m= M;
        while(m-->0){
            int cnt=count2(arr,sc.nextInt());
            sb.append(cnt).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    static int count2(int[] arr,int target){
        int left= 0;
        int right= arr.length-1;
        while(left<=right){
            int mid= (left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right=mid-1;
            }
            else{
                right=mid-1;
            }
        }
        int lowerBoundIdx=left;

        left= 0;
        right= arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        int upperBoundIdx= left;

        return lowerBoundIdx!=upperBoundIdx? upperBoundIdx-lowerBoundIdx:0;

    }

    static int count(int[] arr, int target){

        int left = 0;
        int right= arr.length-1;

        boolean found = false;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right= mid-1;
            }
            else{
                found =true;
                right= mid-1;
            }
        }

        int targetFirstIdx= left;
        if(found){
            int l = targetFirstIdx;
            int r = arr.length-1;
            while(l<=r){
                int m = (l+r)/2;
                int t = -(target+1);

                if(t+arr[m]<0){
                    l=m+1;
                }
                else if(t+arr[m]>0){
                    r=m-1;
                }
                else{
                    r=m-1;
                }
            }
            return l-targetFirstIdx;
        }
        return 0;
    }
    static class FastReader{
        BufferedReader br;
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

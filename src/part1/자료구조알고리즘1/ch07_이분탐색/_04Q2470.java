package part1.자료구조알고리즘1.ch07_이분탐색;

import java.util.*;
import java.io.*;


/**
 * 모든 경우의수를 해보는것이 아니라 이분탐색으로 탐색 범위를 줄여서 탐색함.
 * 이분탐색을 통한 근사값, 최적값 찾기.
 * TreeSet 의 floor() 와 ceiling() 을 이용하여 근사값, 최적값 찾기.
 * floor(target) target 이상(큰거나같은) 최근사값 리턴.
 * ceiling(target) target 이하(작거나같은) 큰 최근사값 리턴.
 * 값이 존재하지않으면 null 반환.
 *
 * 모든 경우의수를 탐색해보기전에 이분탐색으로 범위를 좁혀서 탐색을 해볼 수 있을지 않을까 생각해보기.
 *
 * 탐색 범위가 어차피 끝까지 이므로 함수를 만들때 탐색범위의 끝을 고려하지않았는데, 강의에서는 탐색 범위의 끝도 고려하고 있음.
 * Arrays.binarySearch() 는 target 과 정확히 일치하는 값을 찾아주는것이지 근사값을 찾아주지않음.
 */
public class _04Q2470 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args){
//        solve1();//432ms
//        solve2();//448ms
        solve3();//600ms
    }

    static void solve1(){
        N= sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        int ans1=0, ans2=0;
        int nearestFromZero=Integer.MAX_VALUE;
        for(int i=0; i<N; ++i){
            int pairIdx= findTheNearestPairValueIndex(arr,i);
            int sum=arr[pairIdx] + arr[i];
            if(Math.abs(sum)<nearestFromZero){
                nearestFromZero= Math.abs(sum);
                ans1=Math.min(arr[pairIdx],arr[i]);
                ans2=Math.max(arr[pairIdx],arr[i]);
                if(sum==0){
                    sb.append(ans1).append(" ").append(ans2);
                    System.out.print(sb.toString());
                    System.exit(0);
                }
            }
        }

        sb.append(ans1).append(" ").append(ans2);
        System.out.print(sb.toString());
    }

    static int findTheNearestPairValueIndex(int[] arr, int idx){ //이분탐색으로 최고 근사값 찾기
        int target= -arr[idx];
        if(target ==0 && idx==0){ //0 1 2 일때 0의 짝은 1이 나와야함
            return 1;
        }
        if(target==0 && idx==arr.length-1){ //-2 -1 0 일때 0의 짝은 -1이 나와야함
            return arr.length-2;
        }

        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid= (left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if(arr[mid]>target){
                right= mid-1;
            }
            else{
                return mid;
            }
        }

        if(right>=0 && left<=arr.length-1){

            int num1=arr[left];
            int num2= arr[right];

            int tempIdx =Math.abs(target-num1) <Math.abs(target-num2) ? left : right;

            if(tempIdx ==idx && tempIdx!=0 && tempIdx!=arr.length-1){
                return Math.abs(target-arr[tempIdx-1])< Math.abs(target-arr[tempIdx+1])? tempIdx-1 : tempIdx+1;
            }
            if(tempIdx==idx && tempIdx==0){//-10 1 2 에서  1 1 이 아니라 1 2 가 나와야함
                return tempIdx+1;
            }
            if(tempIdx==idx && tempIdx==arr.length-1){//-2 -1 10 에서 -2 -1 이 나와야함
                return tempIdx-1;
            }
            return tempIdx;
        }
        else{
            if( right<0) { // 1,2,3 에서 1의 페어를 찾는다면 2가 나와야함.
                return left+1;
            }
            return right-1; //-3 -2 -1 에서 -1 의 페어를 찾는다면 -2가 나와야함
        }
    }

    static void solve2(){
        N=sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int minAbs = Integer.MAX_VALUE;
        int ans1=0, ans2=0;
        for(int i=0; i<=N-2; ++i){
            int optimalIdx = findOptimalAbsIndex(arr,i);
            int currentAbs= Math.abs(arr[i]+arr[optimalIdx]);
            if(currentAbs<minAbs){
                minAbs=currentAbs;
                ans1=arr[i];
                ans2=arr[optimalIdx];
            }
        }
        sb.append(ans1).append(" ").append(ans2);
        System.out.print(sb.toString());
    }
    static int findOptimalAbsIndex(int[] arr, int baseIndex){
        int left=baseIndex+1;
        int right= arr.length-1;

        int idx=-1;
        int optimalSum=Integer.MAX_VALUE;
        while(left<=right){
            int mid= (left+right)/2;
            int sum = arr[baseIndex]+arr[mid];
            if(optimalSum>Math.abs(sum)){
                optimalSum=Math.abs(sum);
                idx=mid;
            }
            if(sum<0){
                left=mid+1;
            }
            else if(sum>0){
                right=mid-1;
            }
            else{
                return mid;
            }
        }
        return idx;
    }


    static void solve3(){
        N= sc.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();

        int ans1=0, ans2=0;
        int minSumAbs = Integer.MAX_VALUE;
        int temp=0;
        int n=N;
        while(n-->0){
            temp= sc.nextInt();
            Integer[] pairs={treeSet.floor(-temp),treeSet.ceiling(-temp)};
            for(Integer pair : pairs){
                if(pair==null) continue;

                int sumAbs= Math.abs(temp +pair);
                if(minSumAbs>sumAbs){
                    minSumAbs = sumAbs;
                    ans1= Math.min(temp,pair);
                    ans2= Math.max(temp,pair);
                }
            }
            treeSet.add(temp); //지금 당장은 뒤에 들어올 숫자들이랑 조합을 못해보지만, 나중에 뒤에올 숫자들이 이전에 왔던 숫자들과 조합되므로 상관없음.
        }

        sb.append(ans1).append(" ").append(ans2);
        System.out.print(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

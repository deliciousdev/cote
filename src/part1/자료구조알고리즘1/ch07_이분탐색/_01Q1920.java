package part1.자료구조알고리즘1.ch07_이분탐색;


import java.util.*;
import java.io.*;


/**
 * 1. 입력 할때 체크배열로 표시해두는 방법 : 입력의 범위가 너무 크면 메모리 제한
 * 2. set 을 이용하여 입력들을 기록. ->가능
 * 3. 바이너리 서치 -> 가능   정렬한후 탐색 하면됨: O(logN) : (로그2의 N)  가장 가까운값, ~보다 적은 혹은 큰 숫자 개수 등의 응용 가능
 */
public class _01Q1920 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] A;

    public static void main(String[] args){
        N= sc.nextInt();
        A=new int[N];
        for(int i=0; i<N; ++i){
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        M= sc.nextInt();
        int m= M;
        while(m-->0){
//            boolean found =find(A,sc.nextInt());
//            sb.append(found? 1:0).append("\n");

            int idx = Arrays.binarySearch(A,sc.nextInt());
            sb.append(idx>=0? 1:0).append("\n");
        }

        System.out.print(sb.toString());
    }

    static boolean find(int[] arr, int target){

        int left= 0;
        int right= arr.length-1;

        while(left<=right){
            int mid= (left+right)/2;

            if(arr[mid]>target){
                right=mid-1;
            }
            else if(arr[mid]<target){
                left= mid+1;
            }
            else{
                return true;
            }
        }
        return false;
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

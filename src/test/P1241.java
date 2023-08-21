package test;

import java.util.*;
import java.io.*;

/**
 * 배수의 개수 <-> 약수의 개수 시간복잡도 더 적은것을 적절히 적용하자
 * 약수의 개수를 구하거나 약수를 구할때는 루트(num) 까지만 반복분 돌려주면됨
 */
public class P1241 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int n;
    static int[] frequency= new int[1000000+1];
    static int[] students;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        students=new int[n+1];
        for(int i=1; i<=n; ++i){
            int temp = sc.nextInt();
            ++frequency[temp];
            students[i]=temp;
        }


        for(int i=1; i<students.length; ++i){
            int num = students[i];

            int cnt = sumFrequencyOfAllFactors(num);
            sb.append(cnt-1).append("\n");//자기자신 제외
        }

        System.out.print(sb.toString());
    }

    private static int sumFrequencyOfAllFactors(int num) {
        int j=1;
        int cnt=0;
        for(; j*j< num; ++j){
            if(num %j!=0) continue;

            int factor1= j;
            int factor2= num /j;
            cnt+= frequency[factor1]+frequency[factor2];
        }
        if(j*j== num){
            cnt+=frequency[j];
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

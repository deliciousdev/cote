package part5.단기완성알고리즘._03이분탐색;

import java.util.*;
import java.io.*;

/**
 * 바이너리를 하기위해서 정렬을 해줘야하고, 사전순으로 출력이 되어야하기 때문에 target들도 정렬을 해주거나, 결과를 정렬해주거나 해줘야함
 */
public class __02P1764 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;


    public static void main(String[] args){
        solve1();
    }

    static void solve1() {
        N= sc.nextInt();
        M= sc.nextInt();

        String[] names1 = new String[N];
        String[] names2= new String[M];
        for(int i=0; i<N; ++i){
            names1[i]=sc.next();
        }
        for(int i=0; i<M; ++i){
            names2[i]=sc.next();
        }

        Arrays.sort(names1);
        Arrays.sort(names2);

        int resultCnt=0;
        for(int i=0; i<names1.length; ++i){

            int targetIdx =findTarget(names1[i],names2);
            if(targetIdx!=-1){
                ++resultCnt;
                sb.append(names2[targetIdx]).append("\n");
            }
        }
        System.out.println(resultCnt);
        System.out.print(sb.toString().trim());
    }

    static int findTarget(String target,String[] names){

        int left = 0;
        int right= names.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            int result=target.compareTo(names[mid]);

            if(result>0){
                left=mid+1;
            }
            else if(result<0){
                right=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
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

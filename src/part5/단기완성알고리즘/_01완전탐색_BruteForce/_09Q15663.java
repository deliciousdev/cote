package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

public class _09Q15663 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;

    static int[] combination;
    static int[] arr;

    static int[] result;
    static boolean[] used;

    static int lastUsed;
    static Set<String> set = new TreeSet<>(new MyComparator());

    static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {

            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            for(int i=0; i<split1.length; ++i){
                Integer i1 = Integer.parseInt(split1[i]);
                Integer i2 = Integer.parseInt(split2[i]);
                if(i1!=i2){
                    return i1.compareTo(i2);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args){
//        solve1(); //TreeSet 을 이용한 중복제거, 정렬
        solve2(); //직접 중복고려, 정렬
    }

    static void solve1(){
        N=sc.nextInt();
        M= sc.nextInt();

        combination = new int[M];
        arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        used= new boolean[N];

        rec_func(0);

        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void rec_func(int k){
        if(k==M){
            for(int i=0; i<combination.length; ++i){
                sb.append(arr[combination[i]]).append(" ");
            }
            set.add(sb.toString().trim());
            sb.setLength(0);
            return ;
        }

        for(int i=0; i<N; ++i){

            if(!used[i]) {
                combination[k] = i;
                used[i]=true;
                rec_func(k + 1);
                used[i]=false;
            }
        }
    }


    static void solve2(){
        N=sc.nextInt();
        M=sc.nextInt();
        arr= new int[N+1];
        result= new int[M+1];
        used= new boolean[N+1];



        for(int i=1; i<=N; ++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,1,arr.length);

        rec_func2(1);
        System.out.print(sb.toString().trim());
    }

    static void rec_func2(int k){
        if(k==M+1){
            for(int i=1; i<result.length; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=1; i<=N; ++i){
            if(result[k]==arr[i]) continue;
            if(used[i]) continue;

            used[i]=true;
            result[k]=arr[i];
            rec_func2(k+1);

            used[i]=false;
        }
    }

//    static void rec_func2(int k){
//        if(k==M+1){
//            for(int i=1; i<result.length; ++i){
//                sb.append(result[i]).append(" ");
//            }
//            sb.append("\n");
//
//            return;
//        }
//
//        for(int i=1; i<=N; ++i){
//            if(lastUsed==arr[i]) continue;
//            if(used[i]) continue;
//
//            used[i]=true;
//            lastUsed=arr[i];
//
//            result[k]=arr[i];
//            rec_func2(k+1);
//            result[k]=-1;
//
//            used[i]=false;
//        }
//    }
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

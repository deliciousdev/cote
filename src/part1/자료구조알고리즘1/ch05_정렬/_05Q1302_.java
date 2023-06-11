package part1.자료구조알고리즘1.ch05_정렬;


import java.io.*;
import java.util.*;

public class _05Q1302_ {

    static FastReader sc = new FastReader();

    static int N;
    static String[] books;
    public static void main(String[] args) {

        init();

        Arrays.sort(books);

        String current = books[0];
        int cnt=1;
        int mxCnt=Integer.MIN_VALUE;
        String ans=books[0];
        for(int i=1; i<books.length; ++i){
            if(books[i].equals(current)){
                ++cnt;
                if(cnt>mxCnt){
                    mxCnt=cnt;
                    ans=current;
                }
            }
            else{
                current=books[i];
                cnt=1;
            }
        }

        System.out.print(ans);
    }

    static void init(){
        N= sc.nextInt();
        books = new String[N];

        for(int i=0; i<N; ++i){
            books[i] = sc.next();
        }
    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br =new BufferedReader(new InputStreamReader(System.in));
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

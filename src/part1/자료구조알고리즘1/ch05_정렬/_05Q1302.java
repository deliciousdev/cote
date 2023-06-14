package part1.자료구조알고리즘1.ch05_정렬;


import java.util.*;
import java.io.*;

/**
 * 입력을 받으면서 Map 으로 중복 데이터들의 개수를 카운팅함
 */
public class _05Q1302 {

    static FastReader sc = new FastReader();

    static int N;
    static Map<String,Integer> books;

    public static void main(String[] args){

        init();

        int n= N;
        while(n-->0){
            String bookName = sc.next();
            books.merge(bookName,1,Integer::sum);
//            books.put(bookName,books.getOrDefault(bookName,0)+1);
        }

        int cntMx=Integer.MIN_VALUE;
        String ans="";
        for (String bookName : books.keySet()) {
            int cnt = books.get(bookName);
//        for(Map.Entry<String,Integer> bookData : books.entrySet()){
//            String bookName = bookData.getKey();
//            int cnt = bookData.getValue();

            if(cntMx<cnt){
                cntMx=cnt;
                ans=bookName;
            }
            else if(cntMx==cnt){
                ans= ans.compareTo(bookName) < 0 ? ans :bookName; //결과가 음수면 자리를 바꾸지않음(사전순 정렬) , Integer 도 음수면 자리를 안바꿈(오름차순 정렬)
            }
        }

        System.out.print(ans);

    }

    static void init(){
        N= sc.nextInt();
        books= new HashMap();
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

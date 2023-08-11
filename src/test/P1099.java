package test;

import java.util.*;
import java.io.*;

/**
 * 사실상 브루트포스인데 이것을 dp배열로 푼거임 : 반복되는 연산이 있으므로 메모이제이션으로 효율을 좀 더 높이는것도 적용해보자...
 */
public class P1099 {

    static FastReader sc= new FastReader();

    static int N;
    static ArrayList<Word>[] wordsOfLength = new ArrayList[51];

    static int[] dp; //dp[i] : 주어진 문장에 대해서 길이i 일때까지 비용의 최소값


    public static void main(String[] args){
        solve1();
    }

    static void solve1() {
        String sentence = sc.next();
        dp=new int[sentence.length()+1];
        N = sc.nextInt();
        for(int i=1; i<=50; ++i){
            wordsOfLength[i]=new ArrayList<>();
        }

        for(int i=0; i<N;++i){
            String temp=sc.next();
            wordsOfLength[temp.length()].add(new Word(temp));
        }

        for(int i=1; i<dp.length; ++i){
//            int mn=Integer.MAX_VALUE; //오버플로우 조심
            int mn= 100000;
            for(int length=0; length<i; ++length){
                String sub= sentence.substring(length,i);
                int[] minCost=new int[1];
                if(!validate(sub,minCost)) continue;

                mn=Math.min(mn,dp[length]+minCost[0]);
            }
            dp[i]=mn;
        }

        int ans= dp[sentence.length()];
        System.out.print(ans!=100000 ?ans : -1);
    }

    static boolean validate(String s,int[] minCost){
        minCost[0]=Integer.MAX_VALUE;
        boolean result=false;
        for(Word w : wordsOfLength[s.length()]){
            boolean isValid=true;
            int[] alphabet = new int['z'-'a'+1];

            for(int i=0; i<s.length(); ++i){
                ++alphabet[s.charAt(i)-'a'];
            }

            for(int i=0; i<alphabet.length; ++i){
                if(alphabet[i]!=w.alphabetCnt[i]) {//w.alphabetCnt 를 변경 시키면 뒤에 변경된채로 뒤에 검증 로직에 적용되므로 변경시키면안됨.
                    isValid=false;
                    break;
                }
            }
            if(isValid) {
                result = true;
                minCost[0] = Math.min(minCost[0], calcCost(w.word, s));
            }
        }
        return result;
    }

    static int calcCost(String s1,String s2){
        int cnt=0;
        for(int i=0; i<s1.length(); ++i){
            if(s1.charAt(i)!=s2.charAt(i)) ++cnt;
        }
        return cnt;
    }
    static class Word{
        String word;
        int[] alphabetCnt=new int['z'-'a'+1];

        Word(String s){
            word=s;
            for(int i=0; i<s.length(); ++i){
                ++alphabetCnt[s.charAt(i)-'a'];
            }
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
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

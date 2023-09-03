package test;


import java.util.*;
import java.io.*;

/**
 * 브루트포스로 했는데 정해는 그리디 , 자리 숫자들 가중치 곱할때
 */
public class P1339 {

    static FastReader sc= new FastReader();

    static int n;
    static String[] words;
    static boolean[] exist;
    static ArrayList<Character> alphabets;
    static int[] permutation;
    static boolean[] visited;
    static Map<Character,Integer> indexOf= new HashMap<>();
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
//        solve1(); //브루트포스
        solve2(); //그리디 : 자리숫자들 가중치 곱하면서 다 더할때 스킬
    }

    static void solve2(){
        n= sc.nextInt();
        words= new String[n];
        int[] score = new int['Z'+1];
        for(int i=0; i<n; ++i){
            String word= sc.next();
            words[i]=word;
//            for(int j=0; j<word.length(); ++j){
//                score[word.charAt(j)]+=Math.pow(10,word.length()-j-1);
//            }
            int value= (int)Math.pow(10,word.length()-1);
            for(int j=0; j<word.length(); ++j){
                score[word.charAt(j)] +=  value;
                value/=10;
            }
        }

        Arrays.sort(score,'A','Z'+1);
        int digit=9;
        int sum=0;
        for(int i = 'Z'; i>='A' ; --i){
            sum += score[i]*(digit--);
        }
        System.out.print(sum);
    }

    static void solve1(){
        n= sc.nextInt();
        words= new String[n];
        exist= new boolean['Z'+1];
        for(int i=0; i<n; ++i){
            words[i]=sc.next();
            for(int j=0; j<words[i].length(); ++j){
                exist[words[i].charAt(j)]=true;
            }
        }

        alphabets= new ArrayList<>();
        int cnt=0;
        for(int i='A'; i<='Z'; ++i){
            if(exist[i]){
                alphabets.add((char) i);
                indexOf.put((char)i,cnt++);
            }
        }

        permutation = new int[alphabets.size()];
        visited= new boolean[10];
        backTrackingByDfs(0);

        System.out.print(max);

    }

    static void backTrackingByDfs(int k){
        if(k==alphabets.size()){

            int sum=calcSum(words);
            max=Math.max(max,sum);
            return;
        }

        for(int i=0; i<=9; ++i){
            if(visited[i]) continue;

            visited[i]=true;
            permutation[k]=i;
            backTrackingByDfs(k+1);
            visited[i]=false;
        }
    }


    static int calcSum(String[] words){
        int sum=0;

        for(int i=0; i<words.length; ++i) {
            int number = calcNumber(words[i]);

            sum += number;
        }
        return sum;
    }

    static int calcNumber(String s){
        int result=0;

        for(int i=0; i<s.length(); ++i){
            int idx=indexOf.get(s.charAt(i));
            int digit= permutation[idx];

            result= result*10+digit;
        }
        return result;
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

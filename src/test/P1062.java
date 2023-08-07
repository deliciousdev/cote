package test;

import java.util.*;
import java.io.*;

/**
 * 부르트포스 구현
 * 일반적인 콤비네이션 말고, visited을 이용한 백트래킹 하면 readable 검색하는것이 시간복잡도 유리
 * visited를 이용한 콤비네이션 백트래킹 할때 select 도 같이 파라미터로 넘겨줘야 시간초과안뜸.
 */
public class P1062 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,K;

    static char[] selected;
    static Set[] words;

    static String[] wordArr;

    static boolean[] visited=new boolean[26];
    static int ans=Integer.MIN_VALUE;
    public static void main(String[] args){
//        input1();
//        solve1();

        input2();
        solve2();

    }
    static void input2(){
        N=sc.nextInt();
        K=sc.nextInt();
        if(K <5){
            System.out.print(0);
            System.exit(0);
        }

        wordArr= new String[N];
        for(int i=0; i<N; ++i){
            wordArr[i]=sc.next()
                    .replace("a","").replace("c","")
                    .replace("i","").replace("n","")
                    .replace("t","");
        }

    }

    static void solve2(){
        visited['a'-'a']=true;
        visited['c'-'a']=true;
        visited['i'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        backTracking(0,-1);
        System.out.print(ans);
    }

    static void backTracking(int k,int select){ //select 없이 visited 으로만 백트래킹 하면 시간초과뜸.
        if(k== K-5){
            int readableCnt=0;
            for(String word: wordArr){
                boolean readable= true;
                for(int i=0; i<word.length(); ++i){
                    char c= word.charAt(i);
                    if(!visited[c-'a']){
                        readable=false;
                        break;
                    }
                }
                if(readable) ++readableCnt;
            }
            ans=Math.max(ans,readableCnt);
            return;
        }

        for(int i=select+1; i<26; ++i){
            if(visited[i]) continue;

            visited[i]=true;
            backTracking(k+1,i);
            visited[i]=false;
        }
    }

    private static void input1() {
        N=sc.nextInt();
        K=sc.nextInt();
        if(K <5){
            System.out.print(0);
            System.exit(0);
        }

        words=new Set[N];
        for(int i=0; i<N; ++i){
            words[i]= new HashSet<Character>();
        }
        for(int i=0; i<words.length; ++i){
             char[] c= sc.next().replace("a","").replace("c","")
                    .replace("i","").replace("n","").replace("t","").toCharArray();

             for(int j=0; j<c.length; ++j){
                 words[i].add(c[j]);
             }
        }

        selected= new char[K-5];
    }

    static void solve1(){

        bruteForce_combination(0,'a'-1);
        System.out.print(ans);
    }


    static void bruteForce_combination(int k, int s){
        if(k== K-5){
            int readableCnt=countReadableWord();
//            int readableCnt=countReadableWord2(); //오히려 더걸림
            ans=Math.max(ans,readableCnt);
            return;
        }
        for(int i=s+1; i<'z'+1; ++i){
            if(i=='a'||i=='c'|| i=='i' ||i=='n'||i=='t') continue;

            selected[k]=(char)i;
            bruteForce_combination(k+1,i);
        }
    }

    static int countReadableWord2(){
        int readableCnt=0;
        for(Set<Character> wds:words){
            int cnt=0;
            for(char c : wds){
                for(int i=0; i<selected.length; ++i){
                    if(c==selected[i]){
                        ++cnt;
                        break;
                    }
                }
            }
            if(cnt==wds.size()){
                ++readableCnt;
            }
        }
        return readableCnt;
    }
    static int countReadableWord(){
        int readableCnt=0;
        for(Set<Character> word:words){
            if(word.size()==0){
                ++readableCnt;
                continue;
            }

            int cnt=0;
            for(char c : selected){
                if(word.contains(c)){
                    ++cnt;
                    if(cnt==word.size()){
                        ++readableCnt;
                        break;
                    }
                }
            }

        }
        return readableCnt;
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

package test;

import java.util.*;
import java.io.*;


/**
 * 생각할거 많은 백트래킹
 */
public class P1342 {

    static FastReader sc= new FastReader();
    static StringBuilder sb =new StringBuilder();
    static char[] s ;
    static int cnt;
    static int[] permutation;
    static boolean[] visited;

    static char[] cb;

    static int[] fac;
    static int[] used;
    static Set<String> set= new HashSet<>();
    public static void main(String[] args){
//        solve1();//permutation 을 만든후 문자열을 만들면 백트래킹이 안됨.
//        solve2();//문자열을 만들면서 백트래킹 : 집합에서 최악의 경우 72M 바이트를 까먹음 그래서 메모리 초과나는듯?
//        solve3();//순열 -> 문자열 재배치
        solve4();//알파벳 카드들을 순열로 배치 하여 문자열 만듬 : 중복 걱정 없음
    }

    static void solve4(){
        s= sc.next().toCharArray();
        cb=new char[s.length];
        used = new int['z'+1];
        for(int i=0; i<s.length; ++i){
            ++used[s[i]];
        }
        bruteForceByDfs4(0);
        System.out.print(cnt);
    }
    static void bruteForceByDfs4(int k){
        if(k==s.length){
            ++cnt;
            return ;
        }

        for(int i='a'; i<='z'; ++i){
            if(used[i]<=0) continue;
            if(k!=0 && cb[k-1]==i) continue;

            --used[i];
            cb[k]=(char)i;
            bruteForceByDfs4(k+1);
            cb[k]=0;
            ++used[i];

        }
    }
    static void solve3(){
        s= sc.next().toCharArray();
        visited =new boolean[s.length];
        cb=new char[s.length];

        used = new int['z'+1];
        for(int i=0; i<s.length; ++i){
            ++used[s[i]];
        }
        fac=new int[11];

        bruteForceByDfs3(0);

        for(int i='a'; i<='z'; ++i){
            cnt/=fac(used[i]);
        }
        System.out.print(cnt);
    }

    static int fac(int k){
        if(k==0 || k==1) return 1;
        if(fac[k]!=0) return fac[k];
        return fac[k]= k*fac(k-1);
    }

    static void bruteForceByDfs3(int k){
        if(k==s.length){
            ++cnt;
            return;
        }

        for(int i=0; i<s.length; ++i){
            if(visited[i]) continue;
            if(k!=0 && cb[k-1]==s[i]) continue;

            visited[i]=true;
            cb[k]=s[i];
            bruteForceByDfs3(k+1);
            cb[k]=0;
            visited[i]=false;
        }
    }
    static void solve2(){
        s= sc.next().toCharArray();
        visited =new boolean[s.length];
        cb=new char[s.length];

        bruteForceByDfs2(0);
        System.out.print(cnt);
    }

    static void bruteForceByDfs2(int k){
        if(k==s.length){
            String newString=String.valueOf(cb);
            if( set.add(newString)){
                ++cnt;
            }
            return;
        }

        for(int i=0; i<s.length; ++i){
            if(visited[i]) continue;
            if(k!=0 && cb[k-1]==s[i]) continue;

            visited[i]=true;
            cb[k]=s[i];
            bruteForceByDfs2(k+1);
            cb[k]=0;
            visited[i]=false;
        }

    }
    static void solve1(){
        s= sc.next().toCharArray();
        permutation = new int[s.length];
        visited=new boolean[permutation.length];

        bruteForceByDfs(0);

        System.out.print(cnt);
    }

    static void bruteForceByDfs(int k){
        if(k==permutation.length){

            StringBuilder sb= new StringBuilder();
            for(int i=0; i<k; ++i){
                sb.append(s[permutation[i]]);
            }

            if(set.contains(sb.toString())) return;

            if(isLuckyString(sb.toString())) {
                ++cnt;
                set.add(sb.toString());
            }
            return ;
        }

        for(int i=0; i<permutation.length; ++i){
            if(visited[i]) continue;

            visited[i] =true;
            permutation[k]=i;
            bruteForceByDfs(k+1);
            visited[i]=false;
        }
    }

    static boolean isLuckyString(String s){

        for(int i=1; i<s.length(); ++i){
            if(s.charAt(i-1)==s.charAt(i)) return false;
        }
        return true;
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
    }
}



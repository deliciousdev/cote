package part1.자료구조알고리즘1.ch01문자열.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 문자열 , 부르트포스
 * 단어 검색 할때 String.indexOf() , String.replace()
 */
public class _05Q1543_ {

    static FastReader sc= new FastReader();

    public static void main(String[] args){
//        solve1();//부르트포스 : 그냥 로우레벨로
//        solve2();//indexOf
        solve3();//replace
    }

    static void solve3(){
        String doc= sc.nextLine();
        String target=sc.nextLine();

        String docReplaced=doc.replace(target,"");
        int frequency=(doc.length()-docReplaced.length())/target.length();
        System.out.print(frequency);

    }

    static void solve2(){
        String doc = sc.nextLine();
        String target=sc.nextLine();

        int index=-1;
        int cnt=0;
        int from=0;
        while(from<doc.length()){
            index=doc.indexOf(target,from);
            if(index>=0){
                ++cnt;
                from=index+target.length();
            }
            else{
                break;
            }
        }

        System.out.print(cnt);
    }

    static void solve1(){
        char[] doc=sc.nextLine().toCharArray();
        char[] target=sc.nextLine().toCharArray();


        int cnt=0;
        for(int i=0; i<=doc.length-target.length; ++i){
            if(doc[i]!=target[0]) continue;

            if(isTheSameWord(doc,target,i)){
                ++cnt;
                i+=target.length-1;
            }
        }
        System.out.print(cnt);
    }

    static boolean isTheSameWord(char[] doc, char[] target, int begin){
        for(int i=0; i<target.length; ++i){
            if(target[i]!=doc[i+begin]) return false;
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
    }
}

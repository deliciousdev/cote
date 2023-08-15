package test;

import java.util.*;
import java.io.*;

public class P1107 {

    static FastReader sc= new FastReader();
    static String target;
    static boolean[] notWork;
    static int M;
    public static void main(String[] args){
//        solve1();
        solve2();
    }

    static void solve2(){
        target=sc.next();
        M=sc.nextInt();
        notWork=new boolean[10];
        for(int i=0; i<M; ++i){
            notWork[sc.nextInt()]=true;
        }

        if(allBroken()){
            System.out.print(Math.abs(Integer.parseInt(target)-100));
            System.exit(0);
        }

        int ans =moveNearestNumberAndMoveStepByStep(Integer.parseInt(target));
        ans=Math.min(ans,Math.abs(Integer.parseInt(target)-100));//이게관건임;;

        System.out.print(ans);
    }

    static void solve1(){
        target=sc.next();
        M=sc.nextInt();
        notWork=new boolean[10];
        for(int i=0; i<M; ++i){
            notWork[sc.nextInt()]=true;
        }

        if(allBroken()){
            System.out.print(Math.abs(Integer.parseInt(target)-100));
            System.exit(0);
        }

        if(notUseNumberCase()){
            System.exit(0);
        }

        if (onlyUseNumberCase()) {
            System.out.print(target.length());
            System.exit(0);
        }

        int ans =moveNearestNumberAndMoveStepByStep(Integer.parseInt(target));
        ans=Math.min(ans,Math.abs(Integer.parseInt(target)-100));//이게관건임;;

        System.out.print(ans);
    }
    static boolean allBroken(){
        return M==10;
    }
    static int moveNearestNumberAndMoveStepByStep(int target){

        int d=0;
        int mn=Integer.MAX_VALUE;
        int cnt1=Integer.MAX_VALUE;
        int cnt2=Integer.MAX_VALUE;
        int vc=0;
        while(vc<6){
            int num1= target+d;
            int num2= target-d;
            if(validate(num1)){
                cnt1=String.valueOf(num1).length()+d;
            }

            if(validate(num2)){
                cnt2=String.valueOf(num2).length()+d;
            }
            mn= Math.min(mn,Math.min(cnt1,cnt2));
            if(mn!=Integer.MAX_VALUE){
                ++vc;
            }
            ++d;
        }
        return mn;
    }

    static boolean validate(int number){
        if(number<0) return false;

        String n = String.valueOf(number);
        for(int i=0; i<n.length(); ++i){
            if(notWork[n.charAt(i)-'0']) return false;
        }
        return true;
    }
    static boolean onlyUseNumberCase(){
        for(int i=0; i<target.length(); ++i){
            if(notWork[target.charAt(i)-'0']) return false;
        }
        return true;
    }
    static boolean notUseNumberCase(){
        int target_=Integer.parseInt(target);
        if(98<=target_ && target_<=103){
            System.out.print(Math.abs(100-target_));
            return true;
        }
        return false;
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}

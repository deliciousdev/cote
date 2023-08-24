package test;


import java.util.*;
import java.io.*;

public class P1269 {

    static FastReader sc= new FastReader();

    static int[] a;
    static int[] b;
    public static void main(String[] args){
//        solve1(); //Set 이용
//        solve2(); //Set 이용
        solve3(); //이진탐색
    }

    static void solve3(){
        a=new int[sc.nextInt()];
        b= new int[sc.nextInt()];
        for(int i=0; i<a.length; ++i){
            a[i]=sc.nextInt();
        }
        for(int i=0; i<b.length; ++i){
            b[i]=sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int aSubtractB=a.length;
        for(int e: b){
            if(contains(a,e)) --aSubtractB;
        }

        int bSubtractA=b.length;
        for(int e: a){
            if(contains(b,e)) --bSubtractA;
        }
        System.out.print(aSubtractB+bSubtractA);
    }

    static boolean contains(int[] arr, int target){

        int right=arr.length-1;
        int left= 0;

        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else if( arr[mid]>target){
                right=mid-1;
            }
            else{
                return true;
            }
        }

        return false;
    }

    static void solve2(){
        Set<Integer> a = new HashSet<>();
        Set<Integer> b= new HashSet<>();
        int aLength=sc.nextInt();
        int bLength= sc.nextInt();
        for(int i=0; i<aLength; ++i){
            a.add(sc.nextInt());
        }
        for(int i=0; i<bLength; ++i){
            b.add(sc.nextInt());
        }

        int aSubB =a.size();
        for(int e: b){
            if(a.contains(e)) --aSubB;
        }

        int bSubA= b.size();
        for(int e: a){
            if(b.contains(e)) --bSubA;
        }
        System.out.print(aSubB+bSubA);

    }
    static void solve1(){

        a=new int[sc.nextInt()];
        b= new int[sc.nextInt()];

        for(int i=0; i<a.length; ++i){
            a[i]=sc.nextInt();
        }
        for(int i=0; i<b.length; ++i){
            b[i]=sc.nextInt();
        }
        Set<Integer> aSubtractB = new HashSet<>();
        for(int i=0; i<a.length; ++i){
            aSubtractB.add(a[i]);
        }
        Set<Integer> bSubtractA = new HashSet<>();
        for(int i=0; i<b.length; ++i){
            bSubtractA.add(b[i]);
        }

        for(int e : b){
            aSubtractB.remove(e);
        }
        for(int e: a){
            bSubtractA.remove(e);
        }
        System.out.print(aSubtractB.size()+bSubtractA.size());

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
                }catch(IOException e ){
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

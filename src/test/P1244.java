package test;

import java.util.*;
import java.io.*;

public class P1244 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int[] switchState;

    static Student[] students;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){

        input();

        for(Student student: students){
            student.manipulateSwitch(switchState);
        }

        print(switchState);
    }

    private static void input() {
        switchState= new int[sc.nextInt()+1];
        for(int i=1; i<switchState.length; ++i){
            switchState[i]=sc.nextInt();
        }

        students= new Student[sc.nextInt()];
        for(int i=0; i<students.length; ++i){
            students[i]= new Student(sc.nextInt(), sc.nextInt());
        }
    }

    static void print(int[] switchState){
        int i=1;
        while(i<switchState.length){
            int temp=20;
            while(temp-->0 && i<switchState.length){
                sb.append(switchState[i++]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static class Student{
        int gender;
        int number;
        static final int MALE = 1;
        static final int FEMALE = 2;
        Student(int gender, int number){
            this.gender = gender;
            this.number= number;
        }

        void manipulateSwitch(int[] switchState){
            if(gender == MALE){
                for(int i=number; i<switchState.length; i+=number){
                    switchState[i] = switchState[i]* -1+1;
                }
            }
            else{
                int endIdx=number;
                int startIdx=number;
                while(endIdx+1<switchState.length && startIdx-1>=1 && switchState[endIdx+1]==switchState[startIdx-1]){
                    //startIdx-1>=1 을 startIdx-1>=0 으로 하면 안됨....
                    ++endIdx;
                    --startIdx;
                }
                for(int i=startIdx; i<=endIdx; ++i){
                    switchState[i]= switchState[i]*-1+1;
                }
            }
        }
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

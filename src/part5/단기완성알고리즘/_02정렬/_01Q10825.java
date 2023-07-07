package part5.단기완성알고리즘._02정렬;


import java.util.*;
import java.io.*;

public class _01Q10825 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();


    static int N;
    static Student[] students;


    public static void main(String[] args){
//        solve1(); //Comparable
        solve2(); //Compare
    }

    static void solve1(){
        N= sc.nextInt();
        students = new Student[N];

        for(int i=0; i<N; ++i){
            students[i] = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        Arrays.sort(students);

        for(int i=0; i<students.length; ++i){
            sb.append(students[i].name).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void solve2(){
        N= sc.nextInt();
        students = new Student[N];

        for(int i=0; i<N; ++i){
            students[i] = new Student(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        Arrays.sort(students, (student1,student2)->{
            if(student1.korea!= student2.korea)
                return Integer.compare(student1.korea,student2.korea)* -1;


            if(student1.english != student2.english)
                return Integer.compare(student1.english,student2.english);

            if(student1.math!=student2.math)
                return Integer.compare(student1.math,student2.math)*-1;

            return student1.name.compareTo(student2.name);
        });

        for(int i=0; i<students.length; ++i){
            sb.append(students[i].name).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static class Student implements Comparable<Student>{
        String name;
        int korea;
        int english;
        int math;

        Student(String name, int korea, int english, int math){
            this.name= name;
            this.korea= korea;
            this.english= english;
            this.math= math;
        }

        @Override
        public int compareTo(Student o){

            if(this.korea!=o.korea){
                return Integer.compare(this.korea,o.korea)*-1;
            }

            if(this.english!=o.english){
                return Integer.compare(this.english,o.english);
            }

            if(this.math!=o.math){
                return Integer.compare(this.math,o.math)*-1;
            }

            return this.name.compareTo(o.name);
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
        String nextLine(){
            String str= "";
            try{
                str= br.readLine();
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

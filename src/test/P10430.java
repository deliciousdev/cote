package test;

import java.util.*;
import java.io.*;

public class P10430 {


    public static void main(String[] args) throws IOException {

        StringBuilder sb= new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());

        sb.append((A+B)%C).append("\n")
                .append( ((A%C)+(B%C))%C).append("\n")
                .append( (A*B)%C).append("\n")
                .append( ((A%C)*(B%C))%C);
        System.out.print(sb.toString());
    }
}

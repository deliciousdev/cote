package test;

import java.io.*;
import java.util.*;

public class P2441 {

    public static void main(String[] args) throws IOException {
        int N= new Scanner(System.in).nextInt();
        StringBuilder sb= new StringBuilder();

        for(int i=1; i<=N; ++i){
            for(int space=1;space<=i-1; ++space){
                sb.append(" ");
            }
            for(int star=1;star<=N-i+1; ++star){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
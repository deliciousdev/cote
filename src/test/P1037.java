package test;

import java.util.*;
import java.io.*;

public class P1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int mx= Integer.MIN_VALUE;
        int mn= Integer.MAX_VALUE;
        while(n-->0){
            int num= Integer.parseInt(st.nextToken());
            mx=Math.max(mx,num);
            mn=Math.min(mn,num);
        }

        int ans= mx*mn;
        System.out.print(ans);
    }
}

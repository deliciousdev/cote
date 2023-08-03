package test;

import java.util.Scanner;

public class P2241 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;

        N = input.nextInt();

        for(int i = 0; i < N; i++) {
            for(int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            for(int j = N-i; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
        input.close();
    }
}
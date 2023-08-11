package test;

import java.util.*;
import java.io.*;

public class P1082 {

    static FastReader sc= new FastReader();

    static int N,M;
    static Number[] numbers;
    static int[] cost;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        if(N==1){
            System.out.print(0);
            System.exit(0);
        }

        numbers=new Number[N];
        cost=new int[N];
        for(int i=0; i<numbers.length; ++i){
            int value=i;
            int price= sc.nextInt();
            cost[i]=price;
            numbers[i]=new Number(value,price);
        }
        M=sc.nextInt();

        Arrays.sort(numbers,(n1,n2)-> {
            if(n1.price!=n2.price) return Integer.compare(n1.price,n2.price);
            return Integer.compare(n1.value,n2.value)*-1;
        });

        int[] remainMoney=new int[1];
        StringBuilder longestNumber=calcSimpleLongestNumber(remainMoney);
        if(isAllZero(longestNumber)){
            System.out.print(0);
            System.exit(0);
        }

        changeInToGreatestNumber(longestNumber,remainMoney[0]);

        System.out.print(longestNumber.toString());

    }
    static void changeInToGreatestNumber(StringBuilder sb,int remainMoney){
        Arrays.sort(numbers, Comparator.comparingInt(n -> n.value));
        for(int i=0; i<sb.length(); ++i) {
            int digit = sb.charAt(i) - '0';
            for (int j = numbers.length - 1; j >= 1; --j) {
                int value = numbers[j].value;
                int extraFee = cost[value] - cost[digit];
                if (digit >= value) continue;
                if (remainMoney < extraFee) continue;

                remainMoney -= extraFee;
                sb.setCharAt(i, (char) (value + '0'));
                break;
            }
        }
    }

    static boolean isAllZero(StringBuilder sb){
        for(int i=0; i<sb.length(); ++i){
            if(sb.charAt(i)!='0') return false;
        }
        return true;
    }
    static StringBuilder calcSimpleLongestNumber(int[] remainMoney){
        StringBuilder result=new StringBuilder();

        if(numbers[0].value==0 &&M>=numbers[1].price){
            result.append(numbers[1].value);
            remainMoney[0]= M-numbers[1].price;
        }
        else{
            result.append(numbers[0].value);
            remainMoney[0]=M-numbers[0].price;
        }

        for(int i=1; i<=remainMoney[0]/numbers[0].price; ++i){
            result.append(numbers[0].value);
        }
        remainMoney[0] %= numbers[0].price;
        return result;
    }


    static class Number{
        int value;
        int price;
        Number(int v, int p){
            this.value=v;
            this.price=p;
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
            String str="";
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

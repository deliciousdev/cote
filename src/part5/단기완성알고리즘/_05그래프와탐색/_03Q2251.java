package part5.단기완성알고리즘._05그래프와탐색;

import java.util.*;
import java.io.*;

/**
 * 모든경우의수를 다 탐색 해보는 컨셉임
 */
public class _03Q2251 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static boolean[][][] visit;
    static int[] limit= new int[3];

    static boolean[] answer;

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){

        limit[0]=sc.nextInt();
        limit[1]=sc.nextInt();
        limit[2]=sc.nextInt();
        visit= new boolean[limit[0]+1][limit[1]+1][limit[2]+1];
        answer = new boolean[limit[2] + 1];



        bfs();

//        Collections.sort(ans);
//        for(int i=0; i<=ans.size()-2; ++i){
//            if(ans.get(i)!=ans.get(i+1)){
//                sb.append(ans.get(i)).append(" ");
//            }
//        }
//        sb.append(ans.get(ans.size()-1));


        //ArrayList 로 답을 모으지 않고 배열로체크 해도됨
        for(int i=0; i<answer.length; ++i){
            if(answer[i]) sb.append(i).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    static void bfs(){

        Queue<Buckets> q= new LinkedList();
        visit[0][0][limit[2]]= true;

        q.add(new Buckets(new int[]{0,0,limit[2]}));

        while(!q.isEmpty()){

            Buckets buckets = q.poll();
            if(buckets.volume[0]==0){
                ans.add(buckets.volume[2]);
                answer[buckets.volume[2]]=true;
            }


            for(int i=0; i<3; ++i){
                for(int j=0; j<3;++j ){
                    if(j==i) continue;
                    Buckets b =buckets.move(i,j,limit);
                    if (!visit[b.volume[0]][b.volume[1]][b.volume[2]]) {
                        visit[b.volume[0]][b.volume[1]][b.volume[2]]=true;
                        q.add(b);
                    }
                }
            }

        }

    }

    static class Buckets{

        int[] volume;

        Buckets(int[] volume){
            this.volume= new int[3];
            this.volume[0]=volume[0];
            this.volume[1]=volume[1];
            this.volume[2]=volume[2];
        }

        Buckets move(int from, int to,int[] limit){

            Buckets buckets= new Buckets(this.volume);
            if(buckets.volume[from]+buckets.volume[to]>=limit[to]){
                buckets.volume[from] -= limit[to]-buckets.volume[to];//아래코드랑 이 코드랑 순서 바뀌면 안됨 ... ㅠㅠ 디버깅 하느라 너무 오래걸렸다
                buckets.volume[to]= limit[to];
            }
            else{
                buckets.volume[to] += buckets.volume[from];//아래코드랑 이 코드랑 순서 바뀌면 안됨 ... ㅠㅠ 디버깅 하느라 너무 오래걸렸다
                buckets.volume[from]=0;
            }
            return buckets;
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

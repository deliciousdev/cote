package part5.단기완성알고리즘._06트리;

import java.util.*;
import java.io.*;

/**
 * 포인트 : 큰문제를 해결 하기 어려우니까 작은 문제들을 해결한후 결과를 종합한다.
 * dp: 큰문제를 작은 문제들로 나눈후 작은문제들을 해결한후에 종합하면 큰문제를 해결 할 수 있음.
 * dfs 를 이용하여 자식 노드까지 간후 자식노드들의 리프개수를 구함. 부모노드로 복귀 하였을때, 이미 해결된 자식노드들의 리프개수들을 종합해줌.
 * bfs 와는 다르게 dfs 는 자식노드의 결과를 사용할 수 있음 -> 주로 트리에서는 dfs를 사용하게됨
 */
public class _02Q1068 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static ArrayList<Integer>[] childList;

    static int remove;
    static int root;
    static int[] cnt= new int[51];
    static int[] parentOf = new int[51];

    public static void main(String[] args){
        solve1(); //dp 삭제 노드 위로 형제가 없을때 반례임.
//        solve2(); //dfs
//        solve3();//데이터구조에서 아예 remove 를 삭제를한후 dfs 를 조짐 : 모범답안
    }

    static int count;

    static void solve2(){
        N=sc.nextInt();

        childList = new ArrayList[N];
        for(int i=0; i<N; ++i){
            childList[i] =new ArrayList<>();
        }
        for(int i=0; i<N; ++i){
            int child =i;
            int parent=sc.nextInt();
            if(parent==-1) {
                root=i;
            }
            else{
                childList[parent].add(child);
            }
            parentOf[child]=parent;
        }
        remove = sc.nextInt();

        if(remove==root){
            System.out.print(0);
            System.exit(0);
        }
        dfs2(root);
        System.out.print(count);
    }

    static void dfs2(int currentNode){
        for(int child: childList[currentNode]){
            if(remove==child){
                int siblingSizeOfRemove= childList[currentNode].size();
                if(siblingSizeOfRemove==1) ++count;
                continue;
            }
            dfs2(child);
        }
        if(childList[currentNode].isEmpty()){
            ++count;
        }
    }

    static void solve1(){
        N=sc.nextInt();

        childList = new ArrayList[N];
        for(int i=0; i<N; ++i){
            childList[i] =new ArrayList<>();
        }
        for(int i=0; i<N; ++i){
            int child =i;
            int parent=sc.nextInt();
            if(parent==-1) {
                root=i;
            }
            else{
                childList[parent].add(child);
            }
            parentOf[child]=parent;
        }
        int remove = sc.nextInt();

        if(remove==root){
            System.out.print(0);
            System.exit(0);
        }
        dfs(root);

        int ans= cnt[root]-cnt[remove];
        int siblingSizeOfRemove= childList[parentOf[remove]].size();
        if(siblingSizeOfRemove==1){
            ++ans;
        }
        System.out.print(ans);
    }

    static void dfs(int currentNode){

        /*for(int child: childList[currentNode]){
            dfs(child);
        }

        if(childList[currentNode].isEmpty()){
            ++cnt[currentNode];
        }
        else{
            for(int child: childList[currentNode]){
                cnt[currentNode]+=cnt[child];
            }
        }*/


        if(childList[currentNode].isEmpty()){
            cnt[currentNode]=1;
        }
        for(int child: childList[currentNode]){
            dfs(child);
            cnt[currentNode]+=cnt[child];
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

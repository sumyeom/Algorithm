import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(BFS(N,K));
    }

    public static int BFS(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == end) return cur[1];
            for(int d=0;d<3;d++){
                int next = moveMode(cur[0],d);
                if(next<0||next>100000) continue;
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cur[1]+1});
                }
            }
        }

        return -1;
    }

    public static int moveMode(int cur,int mode){
        if(mode==0) return cur-1;
        else if(mode==1) return cur+1;
        else return cur*2;
    }
}

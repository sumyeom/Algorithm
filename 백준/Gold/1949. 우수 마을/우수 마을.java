import java.util.*;

public class Main {
    static int[] people;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] dp ;
    static  boolean[] visited;
    public static void main(String[] args){
       //System.out.println(solution(new int[][]{{3,2},{6,4},{4,7},{1,4}}, new int[][]{{4,2},{4,2},{2,4}}));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        people = new int[N+1];
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            people[i] = sc.nextInt();
        }

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        dp[1][0] = 0;
        dp[1][1] = people[1];
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    public static void dfs(int cur){
        int max = 0;

        visited[cur] = true;

        dp[cur][0] = 0;
        dp[cur][1] = people[cur];
        for(int i=0;i<graph.get(cur).size();i++){
            int next = graph.get(cur).get(i);
            if(!visited[next]){
                dfs(next);
                dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
                dp[cur][1] += dp[next][0];
            }
        }

    }

}
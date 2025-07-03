import java.util.*;

/**
 * 백준 1759
 * 브루트포스 알고리즘
 * 백트래킹
 */
public class Main {
    static int N;
    static boolean[] visited;
    static int[][] force;
    static List<Integer> list;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        force = new int[N][N];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                force[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int index){
        int start=0;
        int link = 0;
        boolean[] check = new boolean[N];
        List<Integer> another = new ArrayList<>();
        if(list.size() == (N/2)){
            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    int a = list.get(i);
                    int b = list.get(j);
                    start += force[a][b];
                    start += force[b][a];
                    check[a] = true;
                    check[b] = true;
                }
            }

            for(int i=0;i<N;i++){
                if(!check[i]){
                    another.add(i);
                }
            }

            for(int i=0;i<another.size();i++){
                for(int j=i+1;j<another.size();j++){
                    int a = another.get(i);
                    int b = another.get(j);
                    link += force[a][b];
                    link += force[b][a];
                }
            }


            min = Math.min(Math.abs(start-link), min);
            return;
        }
        for(int i=index; i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(index);
                dfs(i+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}




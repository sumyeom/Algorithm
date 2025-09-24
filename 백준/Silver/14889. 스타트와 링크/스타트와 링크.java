
import java.io.IOException;
import java.util.*;

public class Main {
    static int N;
    static boolean[] selected;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

       N = sc.nextInt();
       selected = new boolean[N];

       // 능력 입력
       map = new int[N][N];
       for(int i=0;i<N;i++){
           for(int j=0;j<N;j++){
               map[i][j] = sc.nextInt();
           }
       }

       dfs(0, 0);
       System.out.println(answer);
    }

    public static void dfs(int start, int cnt){
        List<Integer> teamStart = new ArrayList<>();
        List<Integer> teamLink = new ArrayList<>();
        int sumStart = 0, sumLink = 0;
        if(cnt == N/2){
            for(int i=0;i<N;i++){
                if(selected[i]){
                    teamStart.add(i);
                }else{
                    teamLink.add(i);
                }
            }

            for(int i=0;i<teamStart.size();i++){
                for(int j=i+1;j<teamStart.size();j++){
                    sumStart += map[teamStart.get(i)][teamStart.get(j)] + map[teamStart.get(j)][teamStart.get(i)];
                    sumLink += map[teamLink.get(i)][teamLink.get(j)] +  map[teamLink.get(j)][teamLink.get(i)];
                }
            }
            answer = Math.min(answer, Math.abs(sumStart - sumLink));
            return;
        }

        for(int i=start;i<N;i++){
            selected[i] = true;
            dfs(i+1, cnt+1);
            selected[i] = false;
        }
    }
}
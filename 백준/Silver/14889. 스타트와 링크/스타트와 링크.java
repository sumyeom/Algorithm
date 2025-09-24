
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
        int sumStart = 0, sumLink = 0;
        if(cnt == N/2){
            for(int i=0;i<N-1;i++) {
                for(int j=i+1;j<N;j++){
                    if(selected[i] && selected[j]){
                        sumStart += map[i][j] + map[j][i];
                    }else if(!selected[i] && !selected[j]){
                        sumLink += map[i][j] + map[j][i];
                    }
                }
            }
            int val = Math.abs(sumStart - sumLink);
            if(val == 0){
                System.out.println(0);
                System.exit(0);
            }
            answer = Math.min(answer, Math.abs(sumStart - sumLink));
            return;
        }

        for(int i=start;i<N;i++){
            if(!selected[i]){
                selected[i] = true;
                dfs(i+1, cnt+1);
                selected[i] = false;
            }

        }
    }
}
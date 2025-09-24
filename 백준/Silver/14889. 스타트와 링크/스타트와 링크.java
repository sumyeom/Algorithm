import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] selected;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        selected = new boolean[N];

        // 능력 입력
        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected[0] = true;
        dfs(1, 1);

        System.out.println(answer);
    }

    public static void dfs(int start, int cnt){
        int sumStart = 0, sumLink = 0;
        if(cnt == N/2){
            for(int i=0;i<N-1;i++) {
                for(int j=i+1;j<N;j++){
                    if(selected[i] == true && selected[j] == true){
                        sumStart += map[i][j] + map[j][i];
                    }else if(selected[i] == false && selected[j] == false){
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
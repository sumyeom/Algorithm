import java.util.*;

/**
 * 백준 6987
 * 브루트포스 - 경우의 수를 시도
 * 백트래킹 - 시도해보고 다시 돌아가면서 확인 후에 조건을 만족하는지 확인
 */
public class Main {
    static List<int[]> matches;
    static int[][] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test = 0; test < 4 ; test++){
            // 각 팀 인덱스 저장
            // 대진 수는 6C2 - 15
            matches = new ArrayList<>();
            for(int i=0;i<6;i++){
                for(int j=i+1;j<6;j++){
                    matches.add(new int[]{i,j});
                }
            }

            // 결과 저장
            result = new int[6][3];
            for(int i=0;i<6;i++){
                result[i][0] = sc.nextInt();
                result[i][1] = sc.nextInt();
                result[i][2] = sc.nextInt();
            }

            // dfs를 인덱스를 넘겨가면서 진행
            System.out.println(dfs(0) == true ? 1 : 0);
        }
    }

    public static boolean dfs(int matchesIndex){
        // 대진이 15개가 되면 모든 결과가 0인지 아닌지 확인 후 return
        if(matchesIndex == 15){
            return isAllZero(result);
        }

        // 각 대진 돌면서 승/패, 무승부, 패/승 확인 후에 백트래킹
        int first = matches.get(matchesIndex)[0];
        int second = matches.get(matchesIndex)[1];

        // 승/패
        if(result[first][0] > 0 && result[second][2] > 0){
            result[first][0]--; result[second][2]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][0]++; result[second][2]++;
        }

        // 무승부
        if(result[first][1] > 0 && result[second][1] > 0){
            result[first][1]--; result[second][1]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][1]++; result[second][1]++;
        }

        // 패/승
        if(result[first][2] > 0 && result[second][0] > 0){
            result[first][2]--; result[second][0]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][2]++; result[second][0]++;
        }

        return false;
    }

    public static boolean isAllZero(int[][] result){
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                if(result[i][j] != 0 ) return false;
            }
        }
        return true;
    }
}




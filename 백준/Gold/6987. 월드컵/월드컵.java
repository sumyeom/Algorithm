import java.util.*;
public class Main {
    static List<int[]> matches;
    static int[][] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test = 0; test<4; test++){
            matches = new ArrayList<>();
            result = new int[6][3];
            // 대진 만들어 놓음
            for(int i=0;i<6;i++){
                for(int j=i+1;j<6;j++){
                    matches.add(new int[]{i,j});
                }
            }

            // 결과 일단 저장
            for(int i=0;i<6;i++){
                result[i][0] = sc.nextInt();
                result[i][1] = sc.nextInt();
                result[i][2] = sc.nextInt();
            }

            boolean answer = dfs(0);
            System.out.println(answer ? 1:0);
        }

    }

    public static boolean dfs(int matchesIndex){
        if(matchesIndex == 15){
            return checkResult(result);
        }

        int first =  matches.get(matchesIndex)[0];
        int second = matches.get(matchesIndex)[1];

        // first 승 vs second 패
        if(result[first][0] > 0 && result[second][2] > 0){
            result[first][0]--;
            result[second][2]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][0]++;
            result[second][2]++;
        }

        // first vs second 무승부
        if(result[first][1] > 0 && result[second][1] > 0){
            result[first][1]--;
            result[second][1]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][1]++;
            result[second][1]++;
        }

        // first 패 vs second 승
        if(result[first][2] > 0 && result[second][0]>0){
            result[first][2]--;
            result[second][0]--;
            if(dfs(matchesIndex+1)) return true;
            result[first][2]++;
            result[second][0]++;
        }


        return false;
    }

    public static boolean checkResult(int[][] result){
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                if(result[i][j]!=0) return false;
            }
        }

        return true;
    }

}
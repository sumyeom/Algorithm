import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static List<int[]> teacherList = new ArrayList<>();
    static List<int[]> blankList = new ArrayList<>();
    static List<int[]> studentList = new ArrayList<>();
    static boolean answerflag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        String input = sc.nextLine();
        for(int i=0;i<N;i++){
            input = sc.nextLine();
            for(int j=0;j<input.length();j++){
                if(input.charAt(j) == ' ') continue;
                map[i][j/2] = input.charAt(j);
                if(map[i][j/2] == 'T') {
                    teacherList.add(new int[]{i, j/2});
                }else if(map[i][j/2] == 'X'){
                    blankList.add(new int[]{i,j/2});
                }else if(map[i][j/2] == 'S'){
                    studentList.add(new int[]{i,j/2});
                }
            }
        }

        dfs(0,0);
        if(!answerflag){
            System.out.println("NO");
        }

    }

    public static void dfs(int index, int depth){
        if(depth == 3){
            // 선생님 기준으로 확인
            if(isValid()) {
                System.out.println("YES");
                System.exit(0);
                answerflag = true;
            }
            return;
        }

        for(int i=index ; i<blankList.size();i++){
            int x = blankList.get(i)[0];
            int y = blankList.get(i)[1];
            map[x][y] = 'O';
            dfs(i + 1,depth+1);
            map[x][y] = 'X';
        }


    }


    public static boolean isValid(){
        for(int t=0;t<teacherList.size();t++){
            int tX = teacherList.get(t)[0];
            int tY = teacherList.get(t)[1];
            // 가로 확인
            // 왼쪽
            for(int j=tY-1 ; j>=0;j--){
                if(map[tX][j] == 'O'){
                    break;
                }
                if(map[tX][j] == 'S'){
                    return false;
                }
            }

            // 오른쪽
            for(int j = tY+1 ; j<N;j++){
                if(map[tX][j] == 'O'){
                    break;
                }
                if(map[tX][j] == 'S'){
                    return false;
                }
            }

            // 세로 확인
            // 위쪽
            for(int i=tX-1 ; i>=0;i--){
                if(map[i][tY]== 'O'){
                    break;
                }
                if(map[i][tY] == 'S'){
                    return false;
                }
            }

            // 아래쪽
            for(int i=tX+1 ; i<N;i++){
                if(map[i][tY]== 'O'){
                    break;
                }
                if(map[i][tY] == 'S'){
                    return false;
                }
            }

        }

        return true;
    }


}
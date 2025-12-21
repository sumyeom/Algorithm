import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    static boolean[] visited;
    static List<List<Integer>> list;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new boolean[N+1];
        int R = sc.nextInt();

        list = new ArrayList<>();
        for(int i=1;i<=N+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<R;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int start){
        visited[start] = true;
        for(int i=0;i<list.get(start).size();i++){
            if(!visited[list.get(start).get(i)]){
                dfs(list.get(start).get(i));
                answer++;
            }

        }
    }
}
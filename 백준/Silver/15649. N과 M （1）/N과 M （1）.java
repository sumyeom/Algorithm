import java.util.*;
public class Main {
    static int N;
    static int M;
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int max = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=N;i>=1;i--){
            max *= i;
        }
        visited = new boolean[N+1];


        dfs(1);



        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    public static void dfs(int index){
        if(list.size() == M) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }


        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(i);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }




    }





}
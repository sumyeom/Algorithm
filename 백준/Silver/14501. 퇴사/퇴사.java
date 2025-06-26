import java.util.*;

public class Main {
    static int[] todo;
    static int[][] dp ;
    static int[] daysTake;
    static int[] daysPay;
    static  boolean[] visited;
    static int max = 0;
    static int answer = 0;
    static int N;
    public static void main(String[] args){
       //System.out.println(solution(new int[][]{{3,2},{6,4},{4,7},{1,4}}, new int[][]{{4,2},{4,2},{2,4}}));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        todo = new int[N+1];
        dp = new int[N+1][2];
        daysTake = new int[N+1];
        daysPay = new int[N+1];
        
        for(int i=1;i<=N;i++){
            int take = sc.nextInt();
            int pay = sc.nextInt();
            daysTake[i] = take;
            daysPay[i] = pay;

        }


        dfs(1,0);


        System.out.println(answer);

    }

    public static void dfs(int day, int sum){
        if(day > N){
            answer = Math.max(answer, sum);
            return;
        }

        if(day + daysTake[day] <= N){
            dfs(day+daysTake[day],sum+daysPay[day]);
        }else if(day + daysTake[day] <= N+1){
            dfs(day+daysTake[day],sum+daysPay[day]);
        }


        dfs(day+1, sum);

    }

}
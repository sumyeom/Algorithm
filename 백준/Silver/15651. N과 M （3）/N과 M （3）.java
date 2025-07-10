import java.util.*;
public class Main {
    static int N;
    static int M;
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dfs();

        System.out.print(sb); // 한 번만 출력


    }

    public static void dfs(){
        if(list.size() == M ) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1;i<=N;i++){
            list.add(i);
            dfs();
            list.remove(list.size()-1);
        }

    }





}
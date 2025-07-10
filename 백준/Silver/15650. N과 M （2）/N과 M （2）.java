import java.util.*;
public class Main {
    static int N;
    static int M;
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();


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


        for(int i=index;i<=N;i++){
            list.add(i);
            dfs(i+1);
            list.remove(list.size()-1);
        }
    }





}
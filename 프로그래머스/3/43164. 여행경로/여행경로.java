import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> answer ;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        return answer.get(0).split(" ");
    }

   public boolean dfs(String current, String path, String[][] tickets, int count){
        if(count == tickets.length){
            answer.add(path);
            return true;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                if(dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
   }
}
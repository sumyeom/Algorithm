import java.util.*;
class User{
    public int k;
    public int cnt;
    public boolean[] visited;
    public User(int k, int cnt, boolean[] visited){
        this.k = k;
        this.cnt = cnt;
        this.visited = visited;
    }
}
class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        Queue<User> queue = new LinkedList<>();
        boolean[] visited = new boolean[dungeons.length];

        int cnt = 0;
        queue.add(new User(k, cnt, visited));

        while(!queue.isEmpty()){
            User user = queue.poll();
            answer = Math.max(answer, user.cnt);

            for (int i = 0; i < dungeons.length; i++) {
                boolean[] tempVisited = Arrays.copyOf(user.visited, dungeons.length);
                if (!tempVisited[i] && user.k >= dungeons[i][0]) {
                    tempVisited[i] = true;
                    queue.add(new User(user.k - dungeons[i][1], user.cnt + 1, tempVisited));
                }
            }
        }

        return answer;
    }
}
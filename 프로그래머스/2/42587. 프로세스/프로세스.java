import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.offer(new int[]{priorities[i],i});
        }
        int cnt = 0 ;
        while(true){
            int[] cur = queue.poll();
            boolean flag = false;
            for(int[] q : queue){
                if(q[0] > cur[0]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                queue.offer(cur);
            }else{
                cnt++;
                if(location == cur[1]){
                    return cnt;
                }
            }
        }
    }
}
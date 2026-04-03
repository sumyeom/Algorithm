import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        int n = priorities.length;
        for(int i=0;i<n;i++){
            queue.offer(new int[]{priorities[i], i});
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            boolean flag = false;
            for(int[] q : queue){
                if(cur[0] < q[0]){
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
        return 0;
    }
}
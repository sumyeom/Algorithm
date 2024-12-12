import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[] > queue = new LinkedList<>();
        for(int i = 0;i<priorities.length;i++){
            queue.add(new int[]{priorities[i],i});
        }
        int operation = 0;
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            boolean flag = false;

            for(int[] queArray : queue){
                if(queArray[0] > num[0]){
                    flag=true;
                    break;
                }
            }

            if(flag){
                queue.add(num);
            }else{
                operation++;
                if(num[1] == location){
                    return operation;
                }
            }

        }
        return -1;
    }
}
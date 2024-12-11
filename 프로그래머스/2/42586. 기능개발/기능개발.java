import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int num = progresses[i];
            int index=0;
            while(num<100){
                num = num + speeds[i];
                index++;
            }
            list.add(index);
        }
        
        
        int max = list.get(0);
        int count = 1;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=max){
                count++;
            }else{
                answer.add(count);
                max = list.get(i);
                count=1;
            }
        }
        
        answer.add(count);

        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
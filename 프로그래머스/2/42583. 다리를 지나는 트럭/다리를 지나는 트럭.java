import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            queue.add(0); 
        }
        int index = 0;
        int sum = 0;
        while(index < truck_weights.length || sum >0 ){
            answer++;
            int removed = queue.poll();
            sum -= removed;
            if(index < truck_weights.length){
                if(truck_weights[index] + sum <= weight){
                    queue.offer(truck_weights[index]);
                    sum += truck_weights[index];
                    index++;
                }else{
                    queue.offer(0);
                }
            }
        }
        return answer;
    }
}
// 흐름이 순서 기반인가? -> Queue
// 다리위에 트럭이 남아있거나, 아직 건너야될 트럭이 있을때까지 while
// 변수 : 다리 위에 트럭 queue(다리 상태), 현재 무게, 남은 트럭
/**
 while(다리위에 트럭이 남아있거나, 아직 건너야될 트럭이 있다면){
    시간 증가
    다리위의 트럭 건너게하게
    현재 무개 -= 건넌 트럭 무게
    if(현재 무게 + 건널 무게 < 최대 무게) // 인덱스가 끝까지 안갔다면
        건너는 목록에 넣고,
        무게 추가하고
        index 증가
    else
        아무것도 안하니까 0 추가 -> 아무것도 안해도 시간은 지나니까
 
 }
**/


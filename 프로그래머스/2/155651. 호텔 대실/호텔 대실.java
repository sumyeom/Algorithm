// 최소한의 객실만을 사용하여 예약 손님들을 받음
// 한번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소하고 다음 손님들이 사용
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 시작시간 기준으로 정렬
        Arrays.sort(book_time,(a,b) -> a[0].compareTo(b[0]));
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(String[] time : book_time){
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1])+10;
            
            if(!q.isEmpty() && q.peek() <= start){
                q.poll();
            }
            
            q.offer(end);
        }
        answer = q.size();
        return answer;
    }
    
    public int toMinutes(String time){
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        ArrayList<Long> list = new ArrayList<Long>();
        int indexCnt = t.length() - p.length() + 1;
        for(int i = 0;i<indexCnt;i++){
            System.out.println(i+p.length());
            list.add(Long.parseLong(t.substring(i,i+p.length())));
        }
        Long tempP = Long.parseLong(p);
        for(int i=0;i<list.size();i++){
            if(list.get(i) <= tempP){
                answer++;
            }
        }
        
        return answer;
    }
}
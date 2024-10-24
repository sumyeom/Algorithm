import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        LinkedHashMap<Integer, Integer> monthMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> dayMap = new LinkedHashMap<>();
        
        monthMap.put(1, 31);
        monthMap.put(2, 29);
        monthMap.put(3, 31);
        monthMap.put(4, 30);
        monthMap.put(5, 31);
        monthMap.put(6, 30);
        monthMap.put(7, 31);
        monthMap.put(8, 31);
        monthMap.put(9, 30);
        monthMap.put(10, 31);
        monthMap.put(11, 30);
        monthMap.put(12, 31);
        
        dayMap.put(0, "THU");
        dayMap.put(1, "FRI");
        dayMap.put(2, "SAT");
        dayMap.put(3, "SUN");
        dayMap.put(4, "MON");
        dayMap.put(5, "TUE");
        dayMap.put(6, "WED");
        
        for(int i=1;i<a;i++){
            b += monthMap.get(i);
            
        }
        System.out.println(b%7);
        answer = dayMap.get(b%7);
        return answer;
    }
}
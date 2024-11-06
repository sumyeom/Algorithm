import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
        
        LocalDate todayDate = LocalDate.of(todayYear, todayMonth, todayDay);
        
        for(int i=0;i<terms.length;i++){
            String[] term = terms[i].split(" ");
            map.put(term[0],Integer.parseInt(term[1]));
        }
        for(int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            String[] priDate = privacy[0].split("\\.");
            int priYear = Integer.parseInt(priDate[0]);
            int priMonth = Integer.parseInt(priDate[1]);
            int priDay = Integer.parseInt(priDate[2]);
            
            // 시작 날짜로 LocalDate 생성
            LocalDate privacyDate = LocalDate.of(priYear, priMonth, priDay);
            int termMonths = map.get(privacy[1]);
            
            // 약관 기간만큼 월을 추가한 후 하루를 빼서 만료일 계산
            LocalDate expiryDate = privacyDate.plusMonths(termMonths).minusDays(1);
            
            // 오늘 날짜와 만료일 비교
            if (todayDate.isAfter(expiryDate)) {
                list.add(i + 1);
            }
            
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
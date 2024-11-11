import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        LinkedHashMap<String,List<String>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> idMap = new LinkedHashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            idMap.put(id_list[i],0);
        }
        for(int i=0;i<report.length;i++){
            String[] strReport = report[i].split(" ");
            map.computeIfAbsent(strReport[1], list -> new ArrayList<>());
            if(!map.get(strReport[1]).contains(strReport[0])){
                map.get(strReport[1]).add(strReport[0]);
            }

        }
         // 신고 횟수가 k 이상인 유저를 찾아서 처리
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> reporters = map.get(user);

            // null이 아니고, 신고 횟수가 k 이상인 경우에만 처리
            if (reporters != null && reporters.size() >= k) {
                for (String reporter : reporters) {
                    idMap.put(reporter, idMap.get(reporter) + 1);
                }
            }
        }

        // 결과를 answer 배열에 저장
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = idMap.get(id_list[i]);
        }
        return answer;
    }
}
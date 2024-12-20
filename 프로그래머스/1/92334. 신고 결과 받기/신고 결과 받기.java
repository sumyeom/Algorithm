/*
각 유저는 한번에 한명의 유저를 신고할 수 있음
신고 횟수에 제한은 없어서 서로 다른 유저를 신고할 수 있다.
한 유저를 여러번 신고는 할수있지만 동일한 유저에 대한 신고 횟수는 1회로 처리하게됨.
k번 이상 신고된 유저는 정지 -> 해당 유저를 신고한 사람한테 알림이 간다.
마지막에 날림
*/
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
                int[] answer = new int[id_list.length];
        // 신고당한 사람, 신고한 사람 리스트
        Map<String, List<String>> idPeople = new HashMap<>();
        // 신고 당한 사람, 신고 당한 횟수 map
        Map<String, Integer> reportPeople = new HashMap<>();

        // report 돌면서 저장
        for(int i=0;i<report.length;i++){
            String fromPeople = report[i].split(" ")[0];
            String toPeople = report[i].split(" ")[1];
            List<String> fromPeopleList = idPeople.get(toPeople) == null ? new ArrayList<>() : idPeople.get(toPeople);
            //
            if(!fromPeopleList.contains(fromPeople)) {
                fromPeopleList.add(fromPeople);
                reportPeople.put(toPeople, reportPeople.getOrDefault(toPeople, 0) + 1);
            }
            idPeople.put(toPeople, fromPeopleList);

        }

        //
        for(String fromPeople : idPeople.keySet()){
            int num = reportPeople.get(fromPeople);
            if(num >= k) {// k번이상인지 확인
                List<String> list = idPeople.get(fromPeople);
                for(int i=0;i<id_list.length;i++){
                    for(int j=0;j<list.size();j++){
                        if(id_list[i].equals(list.get(j))){
                            answer[i]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
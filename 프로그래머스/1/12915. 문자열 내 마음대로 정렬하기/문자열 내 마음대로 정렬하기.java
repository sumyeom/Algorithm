import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<strings.length;i++){
            list.add(strings[i].charAt(n) + "," + strings[i]);
        }
        Collections.sort(list);
        System.out.println(list);
        for(int i=0;i<strings.length;i++){
            answer[i] = list.get(i).split(",")[1];
        }
        return answer;
    }
}
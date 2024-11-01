import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('F',0);
        map.put('C',0);
        map.put('M',0);
        map.put('J',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i=0;i<survey.length;i++){
            int score = choices[i];
            char type = survey[i].charAt(0);;
            if(1<=score&&score<=3){
                type = survey[i].charAt(0);
            } else if(5<=score && score <= 7){
                type = survey[i].charAt(1);
            }
            
            if(score == 1 || score == 7){
                map.put(type, map.get(type) + 3);
            } else if(score == 2 || score == 6){
                map.put(type, map.get(type) + 2);
            } else if(score == 3 || score == 5){
                map.put(type, map.get(type) + 1);
            }
        }
        
        //R, T 비교
        if(map.get('R') >= map.get('T')){
            answer += "R";
        }else if(map.get('R')<map.get('T')){
            answer += "T";
        }
        
        //C,F 비교
        if(map.get('C') >= map.get('F')){
            answer += "C";
        }else if(map.get('C')<map.get('F')){
            answer += "F";
        }
        
        //J, M 비교
        if(map.get('J') >= map.get('M')){
            answer += "J";
        }else if(map.get('J')<map.get('M')){
            answer += "M";
        }
        
        //A, N 비교
        if(map.get('A')>=map.get('N')){
            answer += "A";
        }else if(map.get('A')<map.get('N')){
            answer +='N';
        }
        
        return answer;
    }
}
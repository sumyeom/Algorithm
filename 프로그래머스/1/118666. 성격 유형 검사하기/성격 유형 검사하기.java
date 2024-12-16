import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Integer> score = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        // 점수
        score.put(1,3);
        score.put(2,2);
        score.put(3,1);
        score.put(5,1);
        score.put(6,2);
        score.put(7,3);
        
        for(int i=0;i<choices.length;i++){
            // 어떤 유형인지 선택할 캐릭터 변수
            char ch;
            
            //비동의인지 동의인지 확인

            if(1<=choices[i] && choices[i]<=3){
                ch = survey[i].charAt(0);
                map.put(ch,map.getOrDefault(ch,0)+score.get(choices[i]));
            }else if(5<=choices[i] && choices[i]<=7){
                ch = survey[i].charAt(1);
                map.put(ch,map.getOrDefault(ch,0)+score.get(choices[i]));
            }
        }
        
        //1번지표 확인
        if(map.get('R')>=map.get('T')){
            answer+="R";
        }else if(map.get('R')< map.get('T')){
            answer +="T";
        }
        
        //2번지표 확인
        if(map.get('C')>=map.get('F')){
            answer+="C";
        }else if(map.get('C')< map.get('F')){
            answer +="F";
        }
        
        //3번지표 확인
        if(map.get('J')>=map.get('M')){
            answer+="J";
        }else if(map.get('J')< map.get('M')){
            answer +="M";
        }
        
        //4번지표 확인
        if(map.get('A')>=map.get('N')){
            answer+="A";
        }else if(map.get('A')< map.get('N')){
            answer +="N";
        }
        
        
        return answer;
    }
}
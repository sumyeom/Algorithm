import java.util.*;
class Solution {
    public int solution(String s) {
        String answerStr = s;
        LinkedHashMap<String, Integer> numberMap = new LinkedHashMap<>();
        numberMap.put("zero",0);
        numberMap.put("one",1);
        numberMap.put("two",2);
        numberMap.put("three",3);
        numberMap.put("four",4);
        numberMap.put("five",5);
        numberMap.put("six",6);
        numberMap.put("seven",7);
        numberMap.put("eight",8);
        numberMap.put("nine",9);
        int indexBegin=0;
        int indexEnd=0;
        for(String key : numberMap.keySet()){
            if(answerStr.contains(key)){
                answerStr = answerStr.replace(key, String.valueOf(numberMap.get(key)));
            }
        }
        
        return Integer.parseInt(answerStr);
    }
}
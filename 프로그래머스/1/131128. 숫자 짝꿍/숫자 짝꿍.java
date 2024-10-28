import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // X와 Y에서 숫자의 빈도를 센다
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        // 9부터 0까지 반복하며 공통 숫자를 큰 수부터 추가
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < commonCount; j++) {
                answer.append(i);
            }
        }
        
        // 결과가 비어있으면 "-1" 반환, "00.."인 경우 "0" 반환
        if (answer.length() == 0) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
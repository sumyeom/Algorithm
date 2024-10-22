class Solution {
    public String solution(String s) {
         String answer = "";
        int index = 0; // 단어 내에서의 인덱스를 추적하는 변수

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer += c;
                index = 0; // 공백을 만나면 단어의 인덱스를 초기화
            } else {
                if (index % 2 == 0) {
                    answer += Character.toUpperCase(c); // 짝수 인덱스는 대문자
                } else {
                    answer += Character.toLowerCase(c); // 홀수 인덱스는 소문자
                }
                index++; // 인덱스를 증가시킴
            }
        }

        return answer;
    }
}
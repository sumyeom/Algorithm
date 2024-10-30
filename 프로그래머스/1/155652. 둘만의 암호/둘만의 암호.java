class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(char ch : s.toCharArray()){
            int cnt = 0;
            while(cnt<index){
                ch = (char) ((ch - 97 +1) % 26 + 97);   
                if(!skip.contains(Character.toString(ch))){
                    cnt++;
                }
            }
            answer += ch;
        }
        return answer;
    }
}
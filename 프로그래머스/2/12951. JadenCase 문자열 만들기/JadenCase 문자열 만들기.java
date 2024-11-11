class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                answer += s.charAt(i);
                continue;
            }
  
            char ch = s.charAt(i);
            if(0 <= ch&& ch <= 9){
                answer += String.valueOf(ch);
                continue;
            }else{
                if(i>0 && s.charAt(i-1)==' ' || i==0){
                    answer += Character.toUpperCase(ch);
                }else{
                    answer += Character.toLowerCase(ch);
                }
            }
        }
        return answer;
    }
}
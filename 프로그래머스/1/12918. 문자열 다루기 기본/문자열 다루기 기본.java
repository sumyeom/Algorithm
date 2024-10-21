import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String REQ = "^[0-9]*$";
        if(s.length()== 4 || s.length()==6){
            answer = Pattern.matches(REQ, s);
        }
        else{
            answer = false;
        }
        return answer;
    }
}
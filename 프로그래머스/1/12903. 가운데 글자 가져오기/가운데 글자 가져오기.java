class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2!=0){
            int temp = s.length()/2;
            char a = s.charAt(temp);
            answer = Character.toString(a);
        }
        else{
            int temp = s.length()/2;
            answer = s.substring(temp-1,temp+1);
        }
        return answer;
    }
}
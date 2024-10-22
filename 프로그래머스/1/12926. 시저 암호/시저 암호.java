class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char tempChar = s.charAt(i);
            if(tempChar==' '){
                answer += tempChar;
                continue;
            }
            if(65 <= tempChar && tempChar <=90){
                if(tempChar+n > 90)
                    tempChar = (char) (tempChar - 26);
                answer += (char)(tempChar+n);
            }
            else if(97 <= tempChar && tempChar <=122){
                if(tempChar+n > 122)
                    tempChar = (char) (tempChar - 26);
                answer += (char)(tempChar+n);
            }
            
        }
        return answer;
    }
}
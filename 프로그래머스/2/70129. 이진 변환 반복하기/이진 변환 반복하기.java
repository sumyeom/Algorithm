class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String strAnswer = s;
        int cnt = 0;
        int len = 0;
        while(true){
            if(strAnswer.equals("1")){
                break;
            }
            int tempLen=0;
            for(int i = 0;i<strAnswer.length();i++){
                if(strAnswer.charAt(i)!='0'){
                    tempLen++;
                }else{
                    len++;
                }
            }
            String temp = "";
            while(true){
                if(tempLen == 1){
                    temp += String.valueOf(tempLen);
                    break;
                }
                temp += String.valueOf(tempLen%2);
                tempLen = tempLen/2;
            }
            
            strAnswer = "";
            for(int i = temp.length()-1;i>=0;i--){
                strAnswer += temp.charAt(i);
            }
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = len;
        return answer;
    }
}
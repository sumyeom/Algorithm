class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int cntP = 0;
        int cntY = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'p' || ch =='P'){
                cntP++;
            }else if(ch == 'y'||ch=='Y'){
                cntY++;
            }
        }
        if(cntP == cntY){
            answer = true;
        }

        return answer;
    }
}
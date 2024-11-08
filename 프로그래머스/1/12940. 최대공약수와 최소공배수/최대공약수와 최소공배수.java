class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {1,1};
        int bigger = n > m ? n : m;
        int div = 1;
        
        for(int i=1;i<=bigger;i++){
            if(n%i == 0 && m%i==0){
                answer[0] = i;
            }
        }
        
        answer[1] = answer[0] * (n/answer[0]) * (m/answer[0]);
        return answer;
    }
}
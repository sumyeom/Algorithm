class Solution {
    public long solution(long n) {
        long answer = 0;
        long temp = 0;
        for(int i=1;i<=n;i++){
            if(n / i == i && n % i ==0) {
                temp = i;
                break;
            }
            if(i == n){
                temp = -1;
            }
        }
        if(temp == -1) answer = -1;
        else answer = (temp+1) * (temp+1);
        return answer;
    }
}
class Solution {
    public int solution(int num) {
        int answer = 0;
        long temp = num;
        if(num == 1) 
            return 0;
        for(int i=0;i<500;i++){
            if(temp % 2 == 0) temp = temp/2;
            else if(temp % 2 != 0) temp = (temp*3)+1;
            System.out.println(temp);
            answer++;
            if(i==499) answer= -1;
            if(temp == 1) break;
        }
        return answer;
    }
}
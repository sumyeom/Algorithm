class Solution {
    public int[] solution(long n) {
        int[] answer;
        long tempAnswer = n;
        long temp = 0;
        int index = 0;
        while(true){
            if(tempAnswer <= 0) break;
            tempAnswer = tempAnswer/10;
            index++;
        }
        answer = new int[index];
        index=0;
        while(true){
            if(n<=0) break;
            temp = n % 10;
            answer[index] = (int)temp;
            n = n / 10;
            index++;
        }
        return answer;
    }
}
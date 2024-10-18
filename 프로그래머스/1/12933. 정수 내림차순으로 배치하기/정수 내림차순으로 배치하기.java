class Solution {
    public long solution(long n) {
        long answer = 0;
        long[] answerList;
        int index=0;
        long div = 0;
        long temp_n = n;
        while(true){
            if(temp_n<=0) break;
            temp_n = temp_n / 10;
            index++;
        }
        answerList = new long[index];
        temp_n = n;
        index = 0;
        while(true){
            if(temp_n<=0) break;
            div = temp_n % 10;
            answerList[index] = div;
            temp_n = temp_n / 10;
            index++;
        }
    
        
        for(int i=0;i<answerList.length-1;i++){
            for(int j=0;j<i;j++){
                if(answerList[i]>answerList[j]){
                    long temp = answerList[i];
                    answerList[i] = answerList[j];
                    answerList[j] = temp;
                }
            }
        }
        for(int i=0;i<answerList.length;i++){
            System.out.print(answerList[i]);
        }
        index = 0;
        for(int i=answerList.length-1;i>=0;i--){
            answer += answerList[i] * Math.pow(10,index++);
        }
        return answer;
    }
}
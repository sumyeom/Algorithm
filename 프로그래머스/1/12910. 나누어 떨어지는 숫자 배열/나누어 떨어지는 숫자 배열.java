class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % divisor == 0){
                index++;
            }
        }
        if(index == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } 
        answer = new int[index];
        index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % divisor == 0){
                answer[index] = arr[i];
                index++;
            }
        }
        
        
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<i;j++){
                if(answer[i]<answer[j]){
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        answer = new int[arr.length-1];
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(min != arr[i]){
                answer[index] = arr[i];
                index++;
            }
        }
        return answer;
    }
}
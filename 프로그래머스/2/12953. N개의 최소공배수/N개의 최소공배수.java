import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int answer = max;
        Arrays.sort(arr);
        int index = 1;
        boolean flag = false;
        while(true){
            answer = max * index;
            for(int i=0;i<arr.length-1;i++){
                if(answer % arr[i] == 0){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                break;
            }
            index++;
        }

        return answer;
    }
}
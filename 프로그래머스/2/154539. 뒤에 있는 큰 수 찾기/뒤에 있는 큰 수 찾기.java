//자신보다 뒤에 있는 숫자 중 자신보다 크면서 가장 가까이 있는 수
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int max = numbers[numbers.length-1];
        int maxIndex = numbers.length-1;
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        for(int i=numbers.length-2;i>=0;i--){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }else if(numbers[i] >= numbers[j]){
                    if(answer[j]==-1){
                        answer[i] = -1;
                        break;
                    }else if(numbers[i] < answer[j]){
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
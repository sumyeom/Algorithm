import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
int answer = 0;
        int sum = 0;
        for(int num : number){
            sum += num;
        }
        for(int i=0;i<discount.length-sum+1;i++){
            String[] splitStr = Arrays.copyOfRange(discount,i,i+sum);
            System.out.println();
            List<String> list = Arrays.asList(splitStr);
            boolean flag = true;
            for(int j=0;j<want.length;j++){
                int cnt = Collections.frequency(list,want[j]);
                if(cnt<number[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}
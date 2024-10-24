import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int num = nums[i]+nums[j] + nums[k];
                    list.add(num);
                }
            }
        }
        boolean flag = true;
        for(int i=0;i<list.size();i++){
            for(int j=2;j<list.get(i);j++){
                if(list.get(i)%j==0){ // 소수가 아님
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                answer++;
            }
            flag = true;
        }

        return answer;
    }
}
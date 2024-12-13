import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
int answer = 0;
        int[] orders = {1,3,2,1};
        Stack<Integer> hamburger = new Stack<>();
        for(int in : ingredient) {
            hamburger.push(in);
            boolean flag = false;
            if(hamburger.size() >=4) {
                for(int j=0;j<4;j++){
                    if(hamburger.get(hamburger.size()-j-1) == orders[j]){
                        flag = true;
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag == true){
                answer++;
                for(int j=0;j<4;j++){
                    hamburger.pop();
                }
            }
        }
        return answer;
    }
}
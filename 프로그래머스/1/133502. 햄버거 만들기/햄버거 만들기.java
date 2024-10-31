import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        int[] orders = {1,2,3,1};
        int index = 0;
        Stack<Integer> hamburger = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for(int i=0;i<ingredient.length;i++){
            hamburger.push(ingredient[i]);
            boolean flag = false;
            if(hamburger.size()>=4){
                for(int j=orders.length-1;j>=0;j--){
                    int number = hamburger.pop();
                    temp.push(number);
                    if(orders[j] == number){
                        flag = true;
                    } else{
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    answer++;
                }else{
                    while(!temp.empty()){
                        hamburger.push(temp.pop());
                    }
                }
                temp.clear();
            }
        }
        return answer;
    }
}
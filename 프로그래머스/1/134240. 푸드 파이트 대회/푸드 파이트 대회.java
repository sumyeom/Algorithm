class Solution {
    public String solution(int[] food) {
        String answer = "";
        int index = 1;
        while(index<food.length){
            int foodNum = food[index];
            for(int i=0;i<foodNum/2;i++){
                answer += index;
            }
            index++;
        }
        answer += 0;
        index = food.length-1;
        while(index>0){
            int foodNum = food[index];
            for(int i=foodNum/2;i>0;i--){
                answer += index;
            }
            index--;
        }
        return answer;
    }
}
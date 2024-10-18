class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<signs.length;i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                int temp = absolutes[i] * (-1);
                answer += temp;
            }
        }
        return answer;
    }
}
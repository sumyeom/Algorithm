import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] apple;
        Arrays.sort(score);
        int index = score.length-1;
        while(true){
            if(list.size() == score.length/m){
                break;
            }
            apple = new int[m];
            for(int i=m-1,j=index;i>=0;i--,j--){
                apple[i] = score[j];
            }
            list.add(apple);
            index -= m;
        }
        for(int i=0;i<list.size();i++){
            answer += list.get(i)[0] * m;
        }
        return answer;
    }
}
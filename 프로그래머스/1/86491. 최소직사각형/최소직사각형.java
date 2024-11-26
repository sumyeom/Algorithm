import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            list1.add(sizes[i][0]);
            list2.add(sizes[i][1]);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        answer = list1.get(list1.size()-1) * list2.get(list2.size()-1);
        return answer;
    }
}
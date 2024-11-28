import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=1;i<=elements.length;i++){
            int sum = 0;
            int index = 0;
            int start = index;
            for(int cnt=0;cnt<elements.length;cnt++){
                start = index ;
                for(int j =0;j<i;j++){
                    sum += elements[start];
                    start++;
                    if(elements.length==start){
                        start = 0;
                    }
                }
                set2.add(sum);
                index++;
                sum=0;
            }

        }
        answer = set2.size();
        return answer;
    }
}
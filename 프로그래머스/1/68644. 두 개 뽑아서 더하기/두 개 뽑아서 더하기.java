import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i] + numbers[j]);
            }
            System.out.println();
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
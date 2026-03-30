import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
int[] notClear = new int[N];
        int[] stagePlayer = new int[N];
        for(int i=1;i<=N;i++){
            for(int j=0;j<stages.length;j++){
                if(stages[j] == i){
                    notClear[i-1]++;
                }
                if(stages[j] >= i){
                    stagePlayer[i-1]++;
                }
                
            }
        }

        HashMap<Integer, Double> map = new HashMap<>();

        for(int i=0;i<N;i++){
            if (stagePlayer[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                map.put(i + 1, (double) notClear[i] / stagePlayer[i]);
            }
        }

        return map.entrySet().stream().sorted((o1, o2) ->
            o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(),o2.getKey()) : 
                    Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }
}
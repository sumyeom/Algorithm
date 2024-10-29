import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        String[] keymap1 = {"A", "A", "B"};
        String[] targets1 = {"B"};
        int[] answer = new int[targets.length];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<targets.length;i++){
            int resultTarget = 0;
            for(int j=0;j<targets[i].length();j++){
                for(int k=0;k<keymap.length;k++){
                    list.add(keymap[k].indexOf(targets[i].charAt(j)));
                }
                int minusCnt = 0;
                for(int k=0;k<list.size();k++){
                    if(list.get(k) == -1){
                        minusCnt++;
                    }
                }
                if(minusCnt == list.size()){
                    resultTarget = -1;
                    list.clear();
                    break;
                }else{
                    while (list.remove(Integer.valueOf(-1))) {        };
                    Collections.sort(list);
                    
                    resultTarget += list.get(0)+1;
                }
                list.clear();
            }
            answer[i] = resultTarget;
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
       int answer = 0;
        int length = Math.min((minerals.length + 4) / 5, picks[0] + picks[1] + picks[2]); // 최대 캘 수 있는 그룹 개수
        List<int[]> mineralsGroup = new ArrayList<>();

        for(int i=0;i<length;i++){
            int dia = 0, iron = 0, stone = 0;
            for(int j=0;j<5&&i*5+j< minerals.length;j++){
                String mineral = minerals[i*5+j];
                if(mineral.equals("diamond")){
                    dia+=1;
                    iron+=5;
                    stone+=25;
                }else if(mineral.equals("iron")){
                    dia+=1;
                    iron+=1;
                    stone+=5;
                }else if(mineral.equals("stone")){
                    dia+=1;
                    iron+=1;
                    stone+=1;
                }
            }
            mineralsGroup.add(new int[]{stone, iron, dia});
        }

        mineralsGroup.sort((a,b) -> b[0] - a[0]);

        for(int[] group : mineralsGroup){
            if(picks[0]>0){
                answer += group[2];
                picks[0]--;
            }else if(picks[1]>0){
                answer += group[1];
                picks[1]--;
            }else if(picks[2]>0){
                answer += group[0];
                picks[2]--;
            }
        }

        return answer;
    } 
}
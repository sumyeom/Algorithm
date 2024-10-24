import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] patternA = {1,2,3,4,5};
        int[] patternB = {2,1,2,3,2,4,2,5};
        int[] patternC = {3,3,1,1,2,2,4,4,5,5};
        int indexA=0;
        int indexB=0;
        int indexC=0;
        int[] countPoint = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i] == patternA[indexA]){
                countPoint[0]++;

            }
            if(answers[i] == patternB[indexB]){
                countPoint[1]++;

            }
            if(answers[i] == patternC[indexC]){
                countPoint[2]++;

            }
            indexA++;
            if(indexA==patternA.length){
                indexA=0;
            }
            indexB++;
            if(indexB==patternB.length){
                indexB=0;
            }
            indexC++;
            if(indexC==patternC.length){
                indexC=0;
            }

        }
        int max = countPoint[0];
        for(int i=0;i<3;i++){
            System.out.println(countPoint[i]);
            if(max < countPoint[i]){
                max = countPoint[i];
            }
        }
        for(int i=0;i<3;i++){
            if(max == countPoint[i]){
                answer.add(i+1);
            }
        }
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
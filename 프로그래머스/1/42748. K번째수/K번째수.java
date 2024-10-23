import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int commandI = commands[i][0];
            int commandJ = commands[i][1];
            int commandK = commands[i][2];
            int[] sortArr = new int[commandJ-commandI+1];
            for(int j=0,k=commandI-1;j<sortArr.length;j++,k++){
                sortArr[j] = array[k];
                System.out.print(sortArr[j] + " ");
            }
            System.out.println();
            Arrays.sort(sortArr);
            for(int j=0;j<sortArr.length;j++){
                System.out.print(sortArr[j]+ " ");
            }
            System.out.println();
            answer[i] = sortArr[commandK-1];
        }
        return answer;
    }
}
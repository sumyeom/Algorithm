import java.util.*;
class Solution {
        static int answer = 0;
    public static int solution(int[] mats, String[][] park) {
        int parkRow = park.length;
        int parkCol = park[0].length;
        Arrays.sort(mats);
        for(int m = mats.length-1;m>=0;m--){
            for(int x=0;x<=park.length-mats[m];x++){
                for(int y=0;y<=park[0].length-mats[m];y++){
                    if(bfs(x, y, mats[m], park)) answer = Math.max(answer, mats[m]);
                }
            }

        }
        
        if(answer == 0) return -1;
        return answer;
    }

    public static boolean bfs(int x, int y, int mat, String[][] park){
        for(int i = x;i<x+mat;i++){
            for(int j=y;j<y+mat;j++){
                if(i < 0 || i >=park.length || j <0 || j>=park[0].length){
                    continue;
                }
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}
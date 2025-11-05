import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    Set<String> visited = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        dfs(info,n,m,0,0,0);
        return answer==Integer.MAX_VALUE ? -1 : answer ;
    }
    
    public void dfs(int[][] info, int n, int m, int cntA, int cntB, int index){
        String key = index + "," + cntA + "," + cntB;
        if(visited.contains(key)) return;
        visited.add(key);
        
        if(n<=cntA || m <= cntB) return;
        if(index >= info.length){
            answer = Math.min(answer, cntA);
            return;
        }
        
        //B훔침
        dfs(info,n,m,cntA,cntB + info[index][1], index+1);
        
        //A훔침
        dfs(info,n,m,cntA + info[index][0], cntB, index+1);
    }
}
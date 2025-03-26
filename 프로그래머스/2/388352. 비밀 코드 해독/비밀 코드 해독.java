import java.util.*;
class Solution {
    private int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        List<Integer> current = new ArrayList<>();
        dfs(n, 1, 0, current, q, ans);
        return answer;
    }

    public void dfs(int n, int start, int count, List<Integer> current, int[][] q, int[] ans){
        // 비밀 코드가 5개가 되면 입력한 정수 배열과 같은지 판단
        if (count == 5) {
            checkAns(current, q, ans);
            return;
        }

        for(int i=start ; i<=n;i++){
            current.add(i);
            dfs(n, i+1, count+1, current, q, ans);
            current.remove(current.size()-1);
        }
    }

    public void checkAns(List<Integer> current, int[][] q, int[] ans){
        //Set으로 조합된 비밀코드와 입력된 정수 확인
        Set<Integer> currentSet = new HashSet<>(current);

        for(int i = 0;i<ans.length;i++){
            int[] inputCode = q[i];
            // 입력한 정수와 몇개가 같은지 확인
            int count = 0;

            for(int j=0;j< inputCode.length;j++){
                if(currentSet.contains(inputCode[j])){
                    count++;
                }
            }

            // 만들어진 조합이 정답과 맞지 않음!
            if(count != ans[i]){
                return;
            }
        }
        answer++;
    }
}
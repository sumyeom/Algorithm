class Solution {
    public int solution(int n, int m, int[] section) {
        int answer=0;
        boolean[] flag = new boolean[n+1];
        boolean change = false;
        for(int i=0;i<section.length;i++){
            for(int j=section[i];j<section[i]+m;j++){
                if(j>n) {
                    break;
                }
                if(flag[j] == true){
                    change = true;
                    break;
                }
                flag[j] = true;
            }
            if(change == false){
                answer++;
            }
            change = false;
        }
        return answer;
    }
}
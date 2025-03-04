class Solution {
    static String letters = "AEIOU";
    static int count = 0;
    static int answer = 0;
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    public void dfs(String current, String target){
        if(current.equals(target)){
            answer = count;
            return;
        }

        if(current.length()==5){
            return;
        }

        for(int i=0;i<5;i++){
            count++;
            dfs(current + letters.charAt(i), target);
            if(answer > 0){
                return;
            }
        }
    }
}
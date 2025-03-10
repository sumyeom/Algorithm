class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, 0, 0, target);
        
        return answer;
    }
    public int dfs(int[] numbers, int index, int value, int target) {
        if(index == numbers.length) {
            if(value == target) {
                return 1;
            }
            return 0;
        }

        int answer1 = dfs(numbers, index+1, value + numbers[index], target);

        int answer2 = dfs(numbers, index+1, value - numbers[index], target);

        return answer1 + answer2;
    }
}
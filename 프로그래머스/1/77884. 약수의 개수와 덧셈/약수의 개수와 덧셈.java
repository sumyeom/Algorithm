class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            int yak = 0;
            for(int j = 1;j<=i;j++){
                if(i%j == 0) yak++;
            }
            System.out.println(yak);
            if(yak%2==0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        return answer;
    }
}
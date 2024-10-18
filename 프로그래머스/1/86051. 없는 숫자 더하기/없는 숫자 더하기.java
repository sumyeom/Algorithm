class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] flags = new boolean[10];
        for(int i=0;i<numbers.length;i++){
           for(int j=0;j<10;j++){
               if(j == numbers[i]){
                   flags[j]=true;
               }
           }
        }
        for(int i=0;i<flags.length;i++){
            if(flags[i] == false){
                answer += i;
                System.out.println(flags[i]);
            }
        }
        return answer;
    }
}
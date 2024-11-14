class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int xPlusy = (brown - 4) / 2; // 가로 + 세로
        int x = 0; //가로
        int y = 0; //세로
        
        int xMuly = yellow;
        
        for(int i=1;i<=xMuly;i++){
            int tempY = xPlusy - i;
            if(i * tempY == xMuly){
                if(i < tempY){
                    answer[0] = tempY+2;
                    answer[1] = i+2;
                }else if(i>=tempY){
                    answer[0] = i+2;
                    answer[1] = tempY+2;
                }
                
                break;
            }
        }
        
        return answer;
    }
}
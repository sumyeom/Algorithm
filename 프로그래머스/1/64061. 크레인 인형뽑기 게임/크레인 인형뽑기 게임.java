import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for(int i=0;i<moves.length;i++){
            int pick = moves[i];
            for(int j=0;j<board.length;j++){
                if(board[j][pick-1] != 0){
                    if(!basket.isEmpty()){
                        int lastOne = basket.peek();
                        if(lastOne == board[j][pick-1]){
                            basket.pop();
                            answer += 2;
                        }else{
                            basket.push(board[j][pick-1]);
                        }
                        
                    }else{
                        basket.push(board[j][pick-1]);
                    }
                    board[j][pick-1] = 0;
                    
                    break;
                }
            }
        }
        return answer;
    }
}
class Solution {
    boolean[][] visited;
    int row = 0;
    int col = 0;
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    boolean answer = false;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == word.charAt(0)){
                    String temp = "" + word.charAt(0);
                    visited[i][j] = true;
                    dfs(i,j,board,word,temp, 1);
                    if(answer) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }
    public void dfs(int cx, int cy, char[][] board, String word, String result, int index){
        if(word.equals(result)){
            answer = true;
            return;
        }

        for(int d=0;d<4;d++){
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col){
                continue;
            }

            if(!visited[nx][ny] && board[nx][ny] == word.charAt(index)){
                visited[nx][ny] = true;
                dfs(nx,ny, board, word, result+word.charAt(index),index+1);
                visited[nx][ny] = false;
            }
        }
    }
}
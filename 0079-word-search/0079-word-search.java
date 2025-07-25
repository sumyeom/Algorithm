class Solution {
    boolean[][] visited;
    int row = 0;
    int col = 0;
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if (dfs(i, j, board, word, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }
    public boolean dfs(int cx, int cy, char[][] board, String word, int index){
        if(word.length() == index){
            return true;
        }

        for(int d=0;d<4;d++){
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col){
                continue;
            }

            if(!visited[nx][ny] && board[nx][ny] == word.charAt(index)){
                visited[nx][ny] = true;
                if (dfs(nx, ny, board, word, index + 1)) return true;
                visited[nx][ny] = false;
            }
        }

        return false;
    }
}
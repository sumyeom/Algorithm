class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] map = new int[N][N];
        map[0][0] = triangle[0][0];
        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                //왼쪽
                if(j-1<0){
                    map[i][j] = map[i-1][j]+ triangle[i][j];
                }else if(triangle[i].length-1 == j) {
                    map[i][j] = map[i-1][j-1]+ triangle[i][j];
                }else{
                    map[i][j] = Math.max(map[i-1][j-1], map[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int j =0;j<N;j++){
            answer = Math.max(answer, map[N-1][j]);
        }
        return answer;
    }
}
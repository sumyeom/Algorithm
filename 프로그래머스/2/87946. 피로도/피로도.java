// 피로도 시스템(0 이상의 정수)
// 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"
// 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"
// 하루에 한번 탐험할 수 있는 던전 있음
// 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려고함
// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도" 담긴 dungeons
// 유저가 탐험할 수 있는 최대 던전 수
class Solution {
    static int answer = -1;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // 던전 방문을 체크할 배열
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons,0);

        return answer;
    }

    public void dfs(int num, int k, int[][] dungeons, int count){

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(num+1, k - dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}
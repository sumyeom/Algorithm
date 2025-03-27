#include<iostream>
#include<queue>
#include<string>
using namespace std;
int N, M, K;
struct map {
	int x, y, w, cnt;
};
char Map[1000][1000];
int dist[1000][1000][10];
queue<map> q;
int bfs();
int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,-1,1,0 };
int break_cnt = 0;
int main() {
	cin >> N >> M >> K;
	break_cnt = K;
	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < M; j++) {
			Map[i][j] = str[j];
		}
	}
	q.push({ 0,0,0,1 });
	dist[0][0][0] = 0;

	cout << bfs();
}
int bfs() {
	while (!q.empty()) {
		int x = q.front().x, y = q.front().y, w = q.front().w, cnt = q.front().cnt;
		q.pop();
		if (x == N - 1 && y == M - 1) return cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (dist[nx][ny][w] == 0) {
					if (Map[nx][ny] == '0') {
						dist[nx][ny][w] = 1;
						q.push({ nx,ny,w, cnt + 1 });
					}
					else if (Map[nx][ny] == '1' && w < K) {
						dist[nx][ny][w + 1] = 1;
						q.push({ nx,ny,w + 1,cnt + 1 });
					}
				}
			}
			
		}
	}
	return -1;
}
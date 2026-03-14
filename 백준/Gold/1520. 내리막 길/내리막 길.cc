#include<iostream>

using namespace std;

#define MAX 500

int N, M;
int Map[MAX][MAX];
int DP[MAX][MAX];
int answer = 0;
int dx[4] = { -1, 0, 0, 1 };
int dy[4] = { 0, -1, 1, 0 };

struct travel {
	int x, y;
};

int dfs(int x, int y);
int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> Map[i][j];
			DP[i][j] = -1;
		}
	}

	answer = dfs(0,0);

	cout << answer; 
}

int dfs(int x, int y) {

	if (x == N - 1 && y == M - 1) {
		return 1;
	}

	if (DP[x][y] == -1) {
		DP[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (Map[nx][ny] != 0 && Map[x][y] > Map[nx][ny]) {
					DP[x][y] += dfs(nx, ny);
				}
			}
		}
	}
	

	return DP[x][y]; 
}
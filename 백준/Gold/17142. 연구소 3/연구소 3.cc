#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

vector<pair<int,int>> Pick_Me;
vector<pair<int, int>> Virus;

int N, M;
int** Map;
int** tmp_Map;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int result[2] = { 987654321, 987654321 };

void DFS(int start_i, int start_j, int depth, int start_index);
bool check_zero(int** tmp_Map);

int main() {
	cin >> N >> M;

	Map = new int* [N];
	tmp_Map = new int* [N];

	for (int i = 0; i < N; i++) {
		Map[i] = new int[N];
		tmp_Map[i] = new int[N];

	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> Map[i][j];
			if (Map[i][j] == 2) {
				Virus.push_back({ i,j });
			}
		}
	}
	DFS(0, 0, 0, 0);
	if (result[0] < 987654321) {
		cout << result[0];
	}
	else {
		cout << result[1];
	}
	
}
void DFS(int start_i, int start_j, int depth, int start_index) {
	if (depth == M) {
		queue<pair<int, int>> q;
		vector<pair<int, int>> cycle;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp_Map[i][j] = Map[i][j];
			}
		}
		int time = 0;
		for (int i = 0; i < Pick_Me.size(); i++) {
			q.push(Pick_Me[i]);
		}
		while (!q.empty()) {
			pair<int, int> q_cur = q.front(); q.pop();
			tmp_Map[q_cur.first][q_cur.second] = 3;
			for (int n = 0; n < 4; n++) {
				int nx = q_cur.first + dx[n];
				int ny = q_cur.second + dy[n];
				if ((0 <= nx && nx < N && 0 <= ny && ny < N) && (tmp_Map[nx][ny] == 0 || tmp_Map[nx][ny] == 2)) {
					if (tmp_Map[nx][ny] == 2) {
						if (check_zero(tmp_Map) == false) {
							tmp_Map[nx][ny]=3;
							cycle.push_back({nx,ny});
						}
					}
					else {
						tmp_Map[nx][ny] = 3;
						cycle.push_back({ nx,ny });
					}
				}
			}
			if (q.empty()) {
				for (int i = 0; i < cycle.size(); i++) {
					q.push(cycle[i]);
				}
				if (cycle.size()) {
					time++;
				}
				cycle.clear();
			}
		}
		
		bool tmp_check = false;
		for (int i = 0; i < N; i++) {
			if (tmp_check == true) {
				break;
			}
			for (int j = 0; j < N; j++) {
				if (tmp_Map[i][j] == 0) {
					tmp_check = true;
					break;
				}
			}
		}
		if (tmp_check == true) {
			result[1] = -1;
		}
		else if (time < result[0]){
			result[0] = time;
		}

		return;
	}

	for (int i = start_index; i < Virus.size(); i++) {
		int next_i = Virus.at(i).first;
		int next_j = Virus.at(i).second;
		Pick_Me.push_back({ next_i, next_j });
		DFS(next_i, next_j, depth + 1, i+1);
		Pick_Me.pop_back();
	}

}
bool check_zero(int** tmp_Map) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (tmp_Map[i][j] == 0) {
				return false;
			}
		}
	}
	return true;
}

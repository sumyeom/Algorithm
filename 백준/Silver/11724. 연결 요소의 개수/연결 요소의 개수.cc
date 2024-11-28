#include<iostream>
#include<vector>
#include<queue>
using namespace std;
void bfs(int start, vector<int>graph[], bool check[]);
int main() {
	int N, M;
	cin >> N >> M;
	int start = 1;
	vector<int> *graph = new vector<int>[N+1];
	bool *check = new bool[N+1];
	for (int i = 0; i <= N; i++) {
		check[i] = false;
	}
	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
	int answer = 0;
	for (int i = 1; i <=N; i++) {
		if (check[i] == false) {
			start = i;
			bfs(start, graph, check);
			answer++;
		}
	}
	cout << answer;
}
void bfs(int start, vector<int>graph[], bool check[]) {
	queue<int> q;
	q.push(start);
	check[start] = true;

	while (!q.empty()) {
		int tmp = q.front();
		q.pop();

		for (int i = 0; i < graph[tmp].size(); i++) {
			if (check[graph[tmp][i]] == false) {
				q.push(graph[tmp][i]);
				check[graph[tmp][i]] = true;
			}
		}
	}
}
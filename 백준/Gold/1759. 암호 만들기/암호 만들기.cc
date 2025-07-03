#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace  std;
void dfs(int start, bool *c, char *list, int depth, string tmp);
bool *c;
vector<string> answer;
int L, C;
int main() {

	cin >> L >> C;
	char *list = new char[C];
	c = new bool[C];
	fill(c, c + C, false);
	for (int i = 0; i < C; i++) {
		cin >> list[i];
	}
	sort(list, list + C);
	for (int i = 0; i < C; i++) {
		string str_temp = "";
		str_temp += list[i];
		dfs(i, c, list, 1, str_temp);
	}

	for (int i = 0; i < answer.size(); i++) {
		cout << answer.at(i);
	}
}
void dfs(int start, bool*c, char *list, int depth, string tmp) {
	bool check = false;
	int cnt = 0;
	if (depth == L) {
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp[i] == 'a' || tmp[i] == 'e' || tmp[i] == 'i' || tmp[i] == 'o' || tmp[i] == 'u') {
				check = true;
				cnt++;
			}
		}
		if (cnt>=1&&L-cnt>=2) {
			answer.push_back(tmp + "\n");
			return;
		}
	}
	c[start] = true;

	for (int i = start; i < C; i++) {
		if (c[i] == false) {
			c[i] = true;
			tmp += list[i];
			dfs(i, c, list, depth + 1, tmp);
			c[i] = false;
			tmp.pop_back();
		}
	}
}
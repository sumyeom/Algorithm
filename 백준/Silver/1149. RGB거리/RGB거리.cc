#include<iostream>
#include<algorithm>
using namespace std;
int main(void) {
	int input;
	cin >> input;
	int **rgb_house = new int*[1001];
	for (int i = 0; i < 1001; i++) {
		rgb_house[i] = new int[3];
	}
	for (int i = 1; i < input+1; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> rgb_house[i][j];
		}
	}
	int **result = new int*[1001];
	for (int i = 0; i < 1001; i++) {
		result[i] = new int[3];
	}

	for (int i = 0; i < 1001; i++) {
		for (int j = 0; j < 3; j++) {
			result[i][j] = 0;
		}
	}

	for (int i = 1; i < input+1; i++) {
		result[i][0] = min(result[i - 1][1], result[i - 1][2]) + rgb_house[i][0];
		result[i][1] = min(result[i - 1][0], result[i - 1][2]) + rgb_house[i][1];
		result[i][2] = min(result[i - 1][0], result[i - 1][1]) + rgb_house[i][2];
	}

	int temp_1;
	int temp_2;
	int answer;
	temp_1 = min(result[input][0], result[input][1]);
	temp_2 = min(result[input][1], result[input][2]);

	if (temp_1 > temp_2) {
		answer = temp_2;
	}
	else
		answer = temp_1;

	cout << answer;
}
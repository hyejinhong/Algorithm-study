#include <iostream>
#include <cmath>
using namespace std;

int n, ans;
int board[10];

bool check(int row)
{
	// 0행~현재 행까지 검사 

	// 같은 열에 있거나, 대각선 내에 있으면 안됨. 
	for (int i = 0; i<row; i++) {
		if (board[row] == board[i] || row - i == abs(board[row] - board[i])) {
			return false;
		}
	}
	return true;
}

void search(int row)
{
	if (row == n) { // 모든 행 탐색 완료
		ans++;
		return;
	}

	for (int i = 0; i<n; i++) {
		board[row] = i; // 현재 행의 각 열마다 퀸을 놓아보자

		if (check(row)) { // 놓은 곳을 체크했는데 놔도 됨 
			search(row + 1); // 그럼 계속 search 하자. 
		}
	}
}

int main()
{
	int t;
	cin >> t;

	for (int test = 1; test <= t; test++) {
		cin >> n;
		ans = 0;

		search(0);

		printf("#%d %d\n", test, ans);
	}
}

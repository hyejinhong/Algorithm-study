#include <iostream>
#include <cmath>
using namespace std;

int n, ans;
int board[10];

bool check(int row)
{
	// 0��~���� ����� �˻� 

	// ���� ���� �ְų�, �밢�� ���� ������ �ȵ�. 
	for (int i = 0; i<row; i++) {
		if (board[row] == board[i] || row - i == abs(board[row] - board[i])) {
			return false;
		}
	}
	return true;
}

void search(int row)
{
	if (row == n) { // ��� �� Ž�� �Ϸ�
		ans++;
		return;
	}

	for (int i = 0; i<n; i++) {
		board[row] = i; // ���� ���� �� ������ ���� ���ƺ���

		if (check(row)) { // ���� ���� üũ�ߴµ� ���� �� 
			search(row + 1); // �׷� ��� search ����. 
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

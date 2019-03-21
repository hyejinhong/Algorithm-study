#include <iostream>
using namespace std;

int main()
{
	int t; // test case;
	cin >> t;

	int d[] = { 0, 1, 1, 0, 0, -1, -1, 0 };

	for (int i = 0; i<t; i++) {
		int n;
		cin >> n;

		// ������ ����
		int** arr = new int*[n + 2];
		for (int j = 0; j < n + 2; j++) {
			arr[j] = new int[n + 2];
		}

		for (int a = 0; a < n + 2; a++) {
			for (int b = 0; b < n + 2; b++) {
				arr[a][b] = 0;
			}
		}

		// ������ �׵θ� = 1
		for (int a = 0; a<n + 2; a++) {
			arr[a][0] = 1;
			arr[0][a] = 1;
			arr[n + 1][a] = 1;
			arr[a][n + 1] = 1;
		}

		int di = 0; // direction index, ���� ������ �� �� +2
		int x = 1;
		int y = 1; // ���� ��ǥ
		int num = 1;

		while (true) {
			arr[x][y] = num;

			// ���� ����
			int dx = d[di];
			int dy = d[di + 1];

			if (num == n*n)
				break;
			// ���� ĭ�� 0�� �ƴ� ��� ���� ��ȯ
			if (arr[x + dx][y + dy] != 0) {
				// ������ ������ ��쿡�� �ٽ� ó�� ��������
				if (di == 6) {
					di = 0;
				}
				else
					di += 2;
				dx = d[di];
				dy = d[di + 1];
			}

			x += dx;
			y += dy;
			num++;
		}

		// ���
		cout << "#" << i + 1 << endl;
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				cout << arr[a][b] << " ";
			}
			cout << endl;
		}

	}
}

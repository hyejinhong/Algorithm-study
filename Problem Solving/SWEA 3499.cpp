#include <iostream>
using namespace std;

const int MAX_LEN = 80;

int main()
{
	int t; // test case
	cin >> t;

	char** arr;

	for (int i = 0; i < t; i++) {
		int n; // 카드 개수
		cin >> n;

		arr = new char*[n];
		
		for (int j = 0; j < n; j++) {
			arr[j] = new char[MAX_LEN];
			cin >> arr[j]; // 카드 이름 입력
		}

		int half; // 중간 카드

		if (n % 2 == 1) { // 홀수
			half = n / 2 + 1;
		}
		else { // 짝수
			half = n / 2;
		}

		cout << "#" << i + 1 << " ";
		
		for (int k = 0; k < half; k++) {
			cout << arr[k] << " ";
			if (k == half - 1 && n % 2 == 1)
				break;
			cout << arr[half + k] << " ";
		}
		cout << endl;
	}

}

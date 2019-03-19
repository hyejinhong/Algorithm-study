#include <iostream>
#include <cstring>
using namespace std;

const int LENGTH = 9;

int main()
{
	int t; // test case
	cin >> t;

	int* arr = new int[t];

	for (int i = 0; i < t; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < t; i++) {
		int year = arr[i] / 10000;
		int month = (arr[i] - year * 10000) / 100;
		int day = arr[i] % 100;

		cout << "#" << i + 1 << " ";

		// month
		if (month < 1 || month > 12) {
			cout << -1 << endl;
			continue;
		}

		// day
		if (day < 1 || day > 31) {
			cout << -1 << endl;
			continue;
		}
		
		// day with month
		if (month == 2 && day > 28) { // 2
			cout << -1 << endl;
			continue;
		}

		if (month < 8 && (month % 2 == 0)) { // 4, 6
			if (day > 30) {
				cout << -1 << endl;
				continue;
			}
		}

		if (month > 8 && (month % 2 == 1)) { // 9, 11
			if (day > 30) {
				cout << -1 << endl;
				continue;
			}
		}

		printf("%04d/%02d/%02d\n", year, month, day);
	}
}

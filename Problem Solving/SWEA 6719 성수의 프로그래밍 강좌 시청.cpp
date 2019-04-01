#include <iostream>
using namespace std;

void selectionSort(int* arr, int n)
{
	// 내림차순
	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (arr[i] < arr[j]) { 
				temp = arr[i]; // 값을 바꿔주기
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

}

int main()
{
	int t; // test case
	cin >> t;

	for (int i = 0; i<t; i++) {
		int n, k;
		cin >> n >> k;

		int* arr = new int[n];
		for (int j = 0; j < n; j++) {
			cin >> arr[j];
		}

		selectionSort(arr, n); // sort
		double result = 0; // 실력

		for (int j = k-1; j >= 0; j--) {
			result = (result + arr[j]) / 2;
		}

		printf("#%d %6f\n", i+1, result);
		// cout << "#" << i + 1 << " " << result << endl;
	}
}

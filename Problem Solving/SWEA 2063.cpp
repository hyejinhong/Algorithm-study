#include <iostream>
using namespace std;

void selectionSort(int* arr, int n)
{
	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j]) { // 나머지 데이터 열에서 최소값이 발견될 경우
				temp = arr[i]; // 값을 바꿔주기
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	int center = n / 2;
	cout << arr[center];
}

int main()
{
	int n;
	cin >> n;

	int* arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	selectionSort(arr, n);
}

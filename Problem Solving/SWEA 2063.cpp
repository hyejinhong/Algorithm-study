#include <iostream>
using namespace std;

void selectionSort(int* arr, int n)
{
	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j]) { // ������ ������ ������ �ּҰ��� �߰ߵ� ���
				temp = arr[i]; // ���� �ٲ��ֱ�
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

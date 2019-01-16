#include <iostream>
using namespace std;

void insertionSort(int* data, int n)
{
	/* parameters
	
	 data: ������ �迭
	 n: arr�� ������ 
	*/
	
	for(int i=1; i<n; i++){
		int temp = data[i]; 	// ���� ���� �ִ� ���� 
		int j = i-1;			// ���� ���� �ִ� �ε��� - 1 
		
		while(data[j] > temp) {	// �� ĭ ���� ���� �� ū ���� �ݺ� 
			data[j+1] = data[j];// ���� ���� �ڸ��� �� ���� ���� 
			j--;				// 1�� ���̸� ���� ���Ұ� �� �ڸ��� ã�� 
		}
		data[j+1] = temp;		// ã�� �ڸ��� ���� ������ 
	}
	
	for(int k=0; k<n; k++){
		// print result
		cout << data[k] << ' ';
	}
}

int main()
{
	int n;
	cin >> n;
	
	int* arr = new int[n];
	for(int i=0; i<n; i++)
		cin >> arr[i];
	
	insertionSort(arr, n);
}

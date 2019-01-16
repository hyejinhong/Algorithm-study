#include <iostream>
using namespace std;

void insertionSort(int* data, int n)
{
	/* parameters
	
	 data: 정렬할 배열
	 n: arr의 사이즈 
	*/
	
	for(int i=1; i<n; i++){
		int temp = data[i]; 	// 현재 보고 있는 원소 
		int j = i-1;			// 현재 보고 있는 인덱스 - 1 
		
		while(data[j] > temp) {	// 한 칸 앞의 값이 더 큰 동안 반복 
			data[j+1] = data[j];// 지금 원소 자리로 그 값을 밀자 
			j--;				// 1씩 줄이며 지금 원소가 들어갈 자리를 찾자 
		}
		data[j+1] = temp;		// 찾은 자리에 집어 넣으셈 
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

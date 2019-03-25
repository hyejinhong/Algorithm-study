#include <iostream>
#include <math.h>
using namespace std;

const int MAX = 1000001;

int main()
{
	int n;
	cin >> n;

	long long * arr = new long long[n];

	// input
	for (int i = 0; i<n; i++) {
		cin >> arr[i];
	}

	
	bool prime[MAX] = {false, }; // false: �Ҽ�, true: �ռ��� 
	
	for(int i=2; i<=MAX; i++) {
		if(prime[i] == false) { // �Ҽ��� ��� 
			for(int j=i*2; j<=MAX; j+=i) { 
				// �� ������� �ɷ��ݴϴ�.. 
				prime[j] = true;
			}
		}
	}

	for (int i = 0; i<n; i++) {
		
		if (arr[i] < 4) {
			cout << "NO" << endl;
			continue;
		}
		
		long long sqrtNum = (long long) sqrt(arr[i]);
		
		// ������ �ƴϰų�, �������� �Ҽ��� �ƴ� ��� 
		if(arr[i] != sqrtNum * sqrtNum || prime[sqrtNum] == true) {
			cout << "NO" << endl;
			
		}
		else {
			cout << "YES" << endl;
		}
		

	}
}


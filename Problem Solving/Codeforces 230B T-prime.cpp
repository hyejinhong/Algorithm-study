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

	
	bool prime[MAX] = {false, }; // false: 소수, true: 합성수 
	
	for(int i=2; i<=MAX; i++) {
		if(prime[i] == false) { // 소수인 경우 
			for(int j=i*2; j<=MAX; j+=i) { 
				// 그 배수들을 걸러줍니다.. 
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
		
		// 제곱이 아니거나, 제곱근이 소수가 아닌 경우 
		if(arr[i] != sqrtNum * sqrtNum || prime[sqrtNum] == true) {
			cout << "NO" << endl;
			
		}
		else {
			cout << "YES" << endl;
		}
		

	}
}


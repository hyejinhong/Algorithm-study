#include <iostream>
using namespace std;

long long max(long long n, long long m) {
	if(n>=m)
		return n;
	else
		return m;
} 

int main()
{
	int n;
	cin >> n;
	
	long long a;
	long long c[100010]; // 숫자 몇개씩 있는지 count해서 저장 
	long long dp[100010]; // dp[i] : 1~i 범위 중 가장 최대값
	
	for(int i=0; i<n; i++) { 
		cin >> a;
		c[a]++;
	}
	 
	dp[0] = 0;
	dp[1] = c[1];
	
	for(int i=2; i<100001; i++) {
		dp[i] = max(dp[i-1], dp[i-2]+c[i]*i);
	}
	
	cout << dp[100000] << endl;
}

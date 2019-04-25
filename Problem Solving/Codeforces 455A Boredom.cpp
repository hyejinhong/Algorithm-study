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
	long long c[100010]; // ���� ��� �ִ��� count�ؼ� ���� 
	long long dp[100010]; // dp[i] : i~N ���� �� ���� �ִ밪, ���� dp[1]�� ���� �� 
	
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

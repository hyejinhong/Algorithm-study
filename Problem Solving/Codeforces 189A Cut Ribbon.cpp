#include <iostream>
using namespace std;

int main()
{
	int n, a, b, c;
	cin >> n >> a >> b >> c;
	int max = 0;

	for (int i = 0; i<n / a + 1; i++) {
		for (int j = 0; j<(n - (a*i))/b + 1; j++) {
			int k = (n - (i*a + j*b)) / c;
			int temp1 = i + j + k;
			int temp2 = i*a + j*b + k*c;

			if (temp1 > max && temp2 == n) {
				max = temp1;
			}
		}
	}
	printf("%d", max);
}

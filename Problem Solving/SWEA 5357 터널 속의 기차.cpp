#include <iostream>
using namespace std;

int main()
{
	int t; // test case
	cin >> t;

	for (int test = 1; test <= t; test++) {
		int N, H;
		cin >> N >> H;

		int a[100001];
		int o[100001];

		for (int i = 0; i<N; i++)
			cin >> a[i];

		for (int i = 0; i<N; i++)
			cin >> o[i];

		int count = 0;
		int result = 0;

		if (o[0] == 0) { // 맨 앞 차
			o[0] = 1;
			result++;
		}
		
		if (o[N-1] == 0) { // 맨 뒷 차
			o[N - 1] = 1;
			result++;
		}

		for (int i = 0; i<N; i++) {

			if (o[i] == 1) {
				count = 0;
			}
			else if (o[i] == 0) {
				count += a[i];
			}

			if (count >= H) {
				o[i] = 1;
				count = 0;
				result++;
			}

		}
		cout << "#" << test << " " << result << endl;
	}
}

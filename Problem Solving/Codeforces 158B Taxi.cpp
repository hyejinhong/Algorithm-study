#include <iostream>
using namespace std;

const int MAX = 100000;

int main()
{
	int group;
	cin >> group;

	int* members = new int[group];
	for (int i = 0; i<group; i++)
		cin >> members[i];

	// 각 명수의 그룹이 몇개씩 있는지 기록
	int data[5] = { 0, };

	for (int i = 0; i<group; i++) {
		data[members[i]]++;
	}

	int taxi = 0;

	// 3명인 그룹이 있으면 
	while (data[3] != 0) {
		// 1명인 그룹과 함께 태움 
		if (data[1] > 0) {
			data[1]--;
			taxi++;
			data[3]--;
		}
		// 1명인 그룹 없으면 그 그룹만 타셈 
		else if (data[1] == 0) {
			data[3]--;
			taxi++;
		}
	}

	// 2명인 그룹 
	while (true) {
		if (data[2] == 1 || data[2] == 0)
			break;

		taxi += data[2] / 2;
		data[2] = data[2] % 2;
	}

	if (data[2] == 1) {
		if (data[1] >= 2) {
			data[2] = 0;
			data[1] -= 2;
			taxi++;
		}
		else {
			data[2] = 0;
			data[1] -= data[1];
			taxi++;
		}
	}

	// 1명인그룹
	if (data[1] >= 4) {
		taxi += data[1] / 4;
		data[1] = data[1] % 4;
	}

	if (data[1] > 0) {
		taxi++;
		data[1] = 0;
	}

	taxi += data[4];

	cout << taxi << endl;

}

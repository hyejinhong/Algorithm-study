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

	// �� ����� �׷��� ��� �ִ��� ���
	int data[5] = { 0, };

	for (int i = 0; i<group; i++) {
		data[members[i]]++;
	}

	int taxi = 0;

	// 3���� �׷��� ������ 
	while (data[3] != 0) {
		// 1���� �׷�� �Բ� �¿� 
		if (data[1] > 0) {
			data[1]--;
			taxi++;
			data[3]--;
		}
		// 1���� �׷� ������ �� �׷츸 Ÿ�� 
		else if (data[1] == 0) {
			data[3]--;
			taxi++;
		}
	}

	// 2���� �׷� 
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

	// 1���α׷�
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

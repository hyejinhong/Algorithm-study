#include <iostream>
using namespace std;

const int MAX = 5000000;

int main()
{
    int input[4];
    for(int i=0; i<4; i++) {
        cin >> input[i];
    }
    
    /* 256 ����� */ 
    int num256 = MAX + 1; // ���� �� �ִ� 256�� ����
    
	for(int i=0; i<4; i++) {
		if(i == 1) // 1 ī��� ���� ���ƶ� 
			continue;
			
		// �ּڰ� ���ϱ� 
		if(num256 > input[i]) {
			num256 = input[i];
		}
	} 
    
    // ī�� ���� ����
	for(int i=0; i<4; i++) {
		if(i == 1) // 1 ī��� ���ֶ�
			continue;
		
		input[i] -= num256; 
	} 
	
	/* 32 ����� */
	int num32 = MAX + 1; // ���� �� �ִ� 32�� ����
	
	for(int i=0; i<2; i++) {
		if(num32 > input[i]) {
			num32 = input[i];
		}
	}
	
	/* �հ� ���ϱ� */
	int result = num256 * 256 + num32 * 32;
	cout << result << endl;
}

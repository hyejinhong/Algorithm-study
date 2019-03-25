#include <iostream>
using namespace std;

const int MAX = 5000000;

int main()
{
    int input[4];
    for(int i=0; i<4; i++) {
        cin >> input[i];
    }
    
    /* 256 만들기 */ 
    int num256 = MAX + 1; // 만들 수 있는 256의 개수
    
	for(int i=0; i<4; i++) {
		if(i == 1) // 1 카드는 세지 말아라 
			continue;
			
		// 최솟값 구하기 
		if(num256 > input[i]) {
			num256 = input[i];
		}
	} 
    
    // 카드 개수 갱신
	for(int i=0; i<4; i++) {
		if(i == 1) // 1 카드는 냅둬라
			continue;
		
		input[i] -= num256; 
	} 
	
	/* 32 만들기 */
	int num32 = MAX + 1; // 만들 수 있는 32의 개수
	
	for(int i=0; i<2; i++) {
		if(num32 > input[i]) {
			num32 = input[i];
		}
	}
	
	/* 합계 구하기 */
	int result = num256 * 256 + num32 * 32;
	cout << result << endl;
}

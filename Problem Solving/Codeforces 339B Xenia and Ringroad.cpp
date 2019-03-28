#include <iostream>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int* task = new int[m];
	
	for(int i=0; i<m; i++) {
		cin >> task[i];
	}	
	
	int time = 0;
	int now = 1;
	int index = 0;
	
	for(int i=0; i<m; i++) {
		if(task[i] > now) {
			time += task[i] - now;
			now = task[i];
		}
		else if(task[i] < now) {
			time += n - now + task[i];
			now = task[i];
		}
	}
	
	cout << time << endl;
}

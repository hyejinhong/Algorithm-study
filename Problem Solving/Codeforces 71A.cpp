#include <iostream>
#include <cstring>

using namespace std;

const int MAX = 100;

int main(void)
{
    int n;
    cin >> n; // lines of words
    
    if(n < 1 || n > 100)
        return 0;
        
    char** data = new char*[n];
    
    for(int i=0; i<n; i++) {
        data[i] = new char[MAX];
    }

    // input    
    for(int i=0; i<n; i++) {
        cin >> data[i];
    }
        
    // check
    for(int i=0; i<n; i++) {
        if(strlen(data[i]) > 10) {
            int num = strlen(data[i]) - 2;
            cout << data[i][0] << num << data[i][strlen(data[i]) - 1] << endl;
            continue;
        }
        else {
            cout << data[i] << endl;
        }
    }
}

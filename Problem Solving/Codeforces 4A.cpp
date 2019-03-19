#include <iostream>
using namespace std;

int main(void)
{
    int w; // weight of the watermelon
    cin >> w;
    
    if(w < 1 || w > 100)
        return 0;
        
    int p, b; // peter, bill
    
    for(int i=1; i<w; i++) {
        p = w - i;
        b = w - p;
        
        if((p%2)==0 && (b%2)==0){
            cout << "YES";
            return 0;
        }
    }
    
    cout << "NO";
    
}

#include <iostream>
using namespace std;

const int MAX = 1000000000;

int main(void)
{
    int n, m, a;
    cin >> n >> m >> a;
    
    if(n < 1 || m < 1 || a < 1)
        return 0;
    
    if(n > MAX || m > MAX || a > MAX)
        return 0;
        
    int row, col; // result
    
    if(n%a == 0)
        row = n/a;
    else
        row = n/a + 1;
        
    if(m%a == 0)
        col = m/a;
    else
        col = m/a + 1;
        
    long long result = (long long) row * col;
    
    cout<< result;
}

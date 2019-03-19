#include <iostream>
#include <cstring>

using namespace std;

const int MAX = 100;

bool vowelsCheck(char n)
{
    char vowels[7] = "aeuioy"; // 0~5
    
    for(int i=0; i<6; i++) {
        if(vowels[i] == n) { // vowel
            return true;
        }
    }
    
    return false;
}

int main(void)
{
    char str[MAX]; // input string
    cin >> str;
    
    int len = strlen(str);

    if(len < 1 || len > MAX) {
        return 0;
    }
    
    // to lower case
    for(int i=0; i<len; i++) {
        if(str[i] >= 'A' && str[i] <= 'Z') { // if upper case
            int n = str[i] - 'A';
            str[i] = 'a' + n;
        }
    }
 
    
    // vowels
    char vowels[7] = "aeuioy"; // 0~5
    
    for(int i=0; i<len; i++) {
        bool b = vowelsCheck(str[i]);
        if(b) { // vowel
            continue;
        }
        else {  // not vowel
            cout << "." << str[i];
            continue;
        }
    }
        
}

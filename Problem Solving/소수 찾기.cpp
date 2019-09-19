#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    bool prime[1000000] = { false, }; // false: 소수, true: 합성수
    
    for(int i=2; i<=n; i++) {
        if(prime[i] == false) { // i가 소수라면..
            answer++;
            for(int j=i*2; j<=n; j+=i) { // i의 배수들을 거름
                prime[j] = true; // 합성수라고 표시
            }
        }
    }
    

    return answer;
}
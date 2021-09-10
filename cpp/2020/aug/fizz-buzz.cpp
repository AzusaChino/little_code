#include <vector>
#include <string>

using std::vector; 
using std::string; 

class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> res(n);
        // 全部写成i
        for(int i = 1;i <= n; i++) {
            res[i - 1] = std::to_string(i);
        }
        // 把3*x都换成Fizz
        for(int i = 2;i < n; i += 3) {
            res[i] = "Fizz";
        }
        // 把5*x都换成Buzz
        for(int i = 4;i < n; i += 5) {
            res[i] = "Buzz";
        }
        // 把15*x都换成FB
        for(int i = 14;i < n; i += 15) {
            res[i] = "FizzBuzz";
        }
        return res;
    }
};

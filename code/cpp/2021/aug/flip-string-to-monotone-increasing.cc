#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int minFlipsMonoIncr(string s, int one = 0, int flip = 0) {
        for (auto ch : s) {
            flip = std::min(one += ch - '0', flip + '1' - ch);
        }
        return flip;
    }
};

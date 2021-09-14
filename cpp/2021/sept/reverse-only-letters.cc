#include <string>

using namespace std;

class Solution {
public:
    string reverseOnlyLetters(string s) {
        using std::swap;
        for (int i = 0, j = s.size()-1; i < j;) {
            if (!isalpha(s[i])) {
                ++i;
            }
            else if (!isalpha(s[j])) {
                --j;
            }
            else {
                swap(s[i++], s[j--]);
            }
        }
        return s;
    }
};
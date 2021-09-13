#include <string>

using namespace std;

class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int count[26] = {0};
        for (char c : text) count[c - 'a']++;
        return min(
            {count[1], count[0], count[11] / 2, count[14] / 2, count[13]});
    }
};

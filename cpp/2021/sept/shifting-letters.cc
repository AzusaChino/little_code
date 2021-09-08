#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string shiftingLetters(string S, vector<int> sh) {
        for (int i = sh.size() - 1, m = 0; i >= 0; --i, m %= 26)
            S[i] = ((S[i] - 'a') + (m += sh[i])) % 26 + 'a';
        return S;
    }
};

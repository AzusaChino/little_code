#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& a, vector<int>& b) {
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        a.erase(
            set_intersection(a.begin(), a.end(), b.begin(), b.end(), a.begin()),
            a.end());
        return a;
    }
    vector<int> intersect(vector<int>& a, vector<int>& b) {
        unordered_map<int, int> ctr;
        for (int i : a) ctr[i]++;
        vector<int> out;
        for (int i : b)
            if (ctr[i]-- > 0) out.push_back(i);
        return out;
    }
};

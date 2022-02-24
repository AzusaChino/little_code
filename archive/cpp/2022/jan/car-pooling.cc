#include <vector>
#include <map>

using namespace std;

class Solution
{
public:
    // 1. save all time points and the change on current capacity
    // 2. Sort all the changes on the key of time points
    // 3. track the current capacity and return false if negative
    bool carPooling(vector<vector<int>> &trips, int capacity)
    {
        map<int, int> m;
        for (auto &t : trips)
        {
            m[t[1]] += t[0];
            m[t[2]] -= t[0];
        }
        // we need a sorted map
        for (auto &v : m)
        {
            if ((capacity -= v.second) < 0)
            {
                return false;
            }
        }
        return true;
    }
};
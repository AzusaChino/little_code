#include <unordered_set>
#include <vector>

using namespace std;

class Solution
{
public:
    int findMaximumXOR(vector<int> &nums)
    {
        int mx = 0, mask = 0;
        unordered_set<int> set;
        for (int i = 31; i >= 0; i--)
        {
            mask |= (1 << i);
            set.clear();

            for (int n : nums)
            {
                set.insert(mask & n);
            }
            int candidate = mx | (1 << i);
            for (int prefix : set)
            {
                if (set.find(prefix ^ candidate) != set.end())
                {
                    mx = candidate;
                    break;
                }
            }
        }
        return mx;
    }
};
#include <unordered_map>
#include <vector>

using namespace std;

class Solution
{
public:
    int subarraySum(vector<int> &nums, int k)
    {
        int sm = 0, cnt = 0;
        unordered_map<int, int> mp;
        mp[0] = 1;

        for (auto i = 0; i < nums.size(); ++i)
        {
            sm += nums[i];
            cnt += mp[sm - k];
            mp[sm]++;
        }
        return cnt;
    }
};

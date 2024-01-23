#include <bitset>
#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    int sumSubarrayMins(vector<int> &nums)
    {
        return 0;
    }

    // if the value in array becomes negative, which means it has been queried before
    vector<int> findErrorNums(vector<int> &nums)
    {
        int n = nums.size();
        int dup = -1;
        for (int i = 0; i < n; i++)
        {
            int index = abs(nums[i]) - 1;
            if (nums[index] < 0)
            {
                dup = abs(nums[i]);
            }
            else
            {
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > 0)
            {
                missing += 1;
            }
        }
        return {dup, missing};
    }

    int maxLength(vector<string> &arr)
    {
        vector<bitset<26>> dp = {bitset<26>()};
        int res = 0;
        for (auto &s : arr)
        {
            bitset<26> tmp;
            for (char c : s)
            {
                tmp.set(c - 'a');
            }
            int n = tmp.count();
            // if current string contains duplicate
            if (n < s.size())
            {
                continue;
            }

            for (int i = dp.size() - 1; i >= 0; --i)
            {
                auto c = dp[i];
                // intersection
                if ((c & tmp).any())
                {
                    continue;
                }
                dp.push_back(c | tmp);
                res = max(res, (int)c.count() + n);
            }
        }

        return res;
    }
};
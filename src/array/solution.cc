#include <algorithm>
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

    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
    {
        // Three pointers to track positions in the arrays
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;

        // Merge from the end of nums1 and nums2
        while (p1 >= 0 && p2 >= 0)
        {
            if (nums1[p1] >= nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements from nums2 if any
        while (p2 >= 0)
        {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    vector<vector<int>> divideArray(vector<int> &nums, int k)
    {
        vector<vector<int>> res;
        std::sort(nums.begin(), nums.end());
        for (int i = 2; i < nums.size(); i += 3)
        {
            if (nums[i] - nums[i - 2] > k)
                return {};
            res.push_back({nums[i - 2], nums[i - 1], nums[i]});
        }
        return res;
    }

    vector<int> sequentialDigits(int low, int high)
    {
        vector<int> ans;
        for (int i = 1; i <= 9; i++)
        {
            int num = i;
            for (int j = i + 1; j <= 9; j++)
            {
                num = num * 10 + j;
                if (num >= low && num <= high)
                {
                    ans.push_back(num);
                }
                if (num > high)
                {
                    break;
                }
            }
        }
        std::sort(ans.begin(), ans.end());

        return ans;
    }
};
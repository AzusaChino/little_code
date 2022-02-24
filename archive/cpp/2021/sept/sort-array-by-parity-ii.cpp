#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> sortArrayByParityII(vector<int> &nums)
    {
        using std::swap;
        for (int i = 0, j = 1; i < nums.size(); i += 2, j += 2)
        {
            while (i < nums.size() && (nums[i] & 1) == 0)
            {
                i += 2;
            }
            while (j < nums.size() && (nums[j] & 1) == 1)
            {
                j += 2;
            }
            if (i < nums.size())
            {
                swap(nums[i], nums[j]);
            }
        }
        return nums;
    }
};
#include <algorithm>
#include <vector>

using namespace std;

class Solution
{
public:
    void rotate(vector<int> &nums, int k)
    {
        ::rotate(nums.rbegin(), nums.rbegin() + k % static_cast<int>(nums.size()), nums.rend());
    }
};
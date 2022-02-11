#include <vector>
#include <numeric>

using namespace std;

class Solution
{
public:
    vector<int> runningSum(vector<int> &nums)
    {
        partial_sum(begin(nums), end(nums), begin(nums));
        return nums;
    }
};
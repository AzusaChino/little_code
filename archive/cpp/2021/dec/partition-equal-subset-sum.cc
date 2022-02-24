#include <vector>
#include <numeric>
#include <bitset>

using namespace std;

class Solution
{
public:
    bool canPartition(vector<int> &nums)
    {
        bitset<10001> bits(1);
        long sum_ = accumulate(nums.begin(), nums.end(), 0);
        for (auto n : nums)
        {
            bits |= bits << n;
        }
        return !(sum_ & 1) && bits[sum_ >> 1];
    }
};
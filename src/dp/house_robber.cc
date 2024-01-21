#include <iostream>
#include <vector>

using namespace std;

class Solution;

int main()
{
    auto s = new Solution();
    auto data = vector({1, 2, 3, 1});
    auto ret = s->rob(data);
    cout << "ret" << ret << endl;
    return 0;
}

class Solution
{
private:
    vector<int> memo;

public:
    int rob(vector<int> &nums)
    {
        this->memo = vector<int>(nums.size(), -1);
        return this->dp(nums, 0);
    }

    int dp(vector<int> &nums, int start)
    {
        if (start >= nums.size())
        {
            return 0;
        }
        if (memo[start] != -1)
        {
            return memo[start];
        }
        int res = max(this->dp(nums, start + 1), nums[start] + this->dp(nums, start + 2));
        memo[start] = res;
        return res;
    }
};
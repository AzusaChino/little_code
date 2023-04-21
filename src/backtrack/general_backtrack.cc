#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> subset(vector<int> nums)
{
    vector<vector<int>> ret;
    if (nums.empty())
    {
        return ret;
    }
    vector<int> track;
    bt(ret, nums, 0, track);
    return ret;
}

void bt(vector<vector<int>> &ret, vector<int> &nums, int start, vector<int> &v)
{
    if (v.size() == nums.size())
    {
        ret.push_back(v);
        return;
    }

    for (int i = start; i < nums.size(); i++)
    {
        v.push_back(nums[i]);
        bt(ret, nums, i + 1, v);
        v.pop_back();
    }
}

vector<vector<int>> combine(int n, int k)
{
    vector<vector<int>> ret;
    if (k <= 0 || n <= 0)
    {
        return ret;
    }
    vector<int> track;
    backtrack(ret, n, k, 1, track);
    return ret;
}

void backtrack(vector<vector<int>> &ret, int n, int k, int start, vector<int> &v)
{
    if (v.size() == k)
    {
        ret.push_back(v);
        return;
    }
    for (int i = start; i <= n; i++)
    {
        v.push_back(i);
        backtrack(ret, n, k, i + 1, v);
        v.pop_back();
    }
}

vector<vector<int>> permutation(vector<int> nums)
{
    vector<vector<int>> ret;
    if (nums.empty())
    {
        return ret;
    }
    vector<int> track;
    backtrack1(ret, nums, track);
    return ret;
}

void backtrack1(vector<vector<int>> &ret, vector<int> &nums, vector<int> &v)
{
    if (v.size() == nums.size())
    {
        ret.push_back(v);
        return;
    }
    for (size_t i = 0; i < nums.size(); i++)
    {
        if (std::count(v.begin(), v.end(), nums[i]) > 0)
        {
            continue;
        }
        v.push_back(nums[i]);
        backtrack1(ret, nums, v);
        v.pop_back();
    }
}
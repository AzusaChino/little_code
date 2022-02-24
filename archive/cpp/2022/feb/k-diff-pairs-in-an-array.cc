#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution
{
public:
    // another thought, using sort and compare every two while looping
    int findPairs(vector<int> &nums, int k)
    {
        if (k < 0)
        {
            return 0;
        }
        // using map for quick search
        unordered_set<int> starters;
        unordered_map<int, int> indices;
        for (int i = 0; i < nums.size(); i++)
        {
            if (indices.count(nums[i] - k))
            {
                starters.insert(nums[i] - k);
            }
            if (indices.count(nums[i] + k))
            {
                starters.insert(nums[i]);
            }

            indices[nums[i]] += 1;
        }

        return starters.size();
    }
};
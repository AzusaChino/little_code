#include <vector>
#include <map>

using namespace std;

class Solution
{
public:
    int minimumRounds(vector<int> &tasks)
    {
        map<int, int> mp;
        for (auto i = 0; i < tasks.size(); i++)
        {
            mp[tasks[i]]++;
        }
        int output = 0;
        for (auto freq : mp)
        {
            if (freq.second == 1)
            {
                return -1;
            }
            if ((freq.second % 3) == 0)
            {
                output += freq.second / 3;
            }
            else
            {
                // no matter the reminder is 1/2, we could take number from last 3,
                // so one more operation needed
                output += freq.second / 3 + 1;
            }
        }
        return output;
    }
};
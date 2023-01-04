#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    int minDeletionSize(vector<string> &strs)
    {
        if (strs.empty())
        {
            return 0;
        }

        auto cnt = 0;
        auto row = strs.size();
        auto col = strs[0].size();

        // loop twice and compare each char with prev one, to check incremental
        for (auto j = 0; j < col; j++)
        {
            for (auto i = 0; i < row - 1; i++)
            {
                if (strs[i][j] > strs[i + 1][j])
                {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
};
#include <vector>

using namespace std;

class Solution
{
public:
    int findJudge(int n, vector<vector<int>> &trust)
    {
        vector<int> val(n + 1);
        for (auto t : trust)
        {
            val[t[0]]--;
            val[t[1]]++;
        }

        for (int i = 1; i <= n; ++i)
        {
            if (val[i] == n - 1)
            {
                return i;
            }
        }

        return -1;
    }
};
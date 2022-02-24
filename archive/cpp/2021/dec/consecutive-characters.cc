#include <string>

using namespace std;

class Solution
{
public:
    int maxPower(string s)
    {
        int res = 1;
        int count = 1;
        char cur = s[0];
        for (auto i = 1; i < s.size(); ++i)
        {
            if (cur == s[i])
            {
                count++;
                res = max(res, count);
            }
            else
            {
                cur = s[i];
                count = 1;
            }
        }
        return res;
    }
};
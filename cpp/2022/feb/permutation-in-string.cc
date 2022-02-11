#include <string>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    bool checkInclusion(string s1, string s2)
    {
        unordered_map<char, int> t_m, w_m;
        for (char c : s1)
        {
            if (t_m.count(c))
            {
                t_m[c]++;
            }
            else
            {
                t_m[c] = 0;
            }
        }
        int l = 0, r = 0, valid = 0;
        while (r < s2.size())
        {
            auto c = s2[r++];
            if (t_m.count(c))
            {
                if (w_m.count(c))
                {
                    w_m[c]++;
                }
                else
                {
                    w_m[c] = 0;
                }
                if (t_m[c] == w_m[c])
                {
                    valid++;
                }
            }
            while (r - l >= s1.size())
            {
                if (valid == t_m.size())
                {
                    return true;
                }
                auto d = s2[l++];
                if (t_m.count(d))
                {
                    if (t_m[d] == w_m[d])
                    {
                        valid--;
                    }
                    w_m[d]--;
                }
            }
        }
        return false;
    }
};
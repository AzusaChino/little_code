#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    int atMostNGivenDigitSet(vector<string> &digits, int n)
    {
        string ns = to_string(n);
        int digit = ns.size(), sz = digits.size(), res = 0;

        for (int i = 1; i < digit; ++i)
        {
            res += pow(sz, i);
        }
        for (int i = 0; i < digit; ++i)
        {
            bool has_same_num = false;
            for (string &d : digits)
            {
                if (d[0] < ns[i])
                {
                    res += pow(sz, digit - i - 1);
                }
                else if (d[0] == ns[i])
                {
                    has_same_num = true;
                }
            }
            if (!has_same_num)
            {
                return res;
            }
        }
        return res + 1;
    }
};

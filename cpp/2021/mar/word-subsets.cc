#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    vector<string> wordSubsets(vector<string> &A, vector<string> &B)
    {
        vector<int> count(26), tmp(26);
        int i;
        for (string b : B)
        {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
            {
                count[i] = max(count[i], tmp[i]);
            }
        }
        vector<string> ret;
        for (auto cb = A.cbegin(); cb != A.cend(); ++cb)
        {
            string s = *cb;
            tmp = counter(s);
            for (i = 0; i < 26; ++i)
            {
                if (tmp[i] < count[i])
                {
                    break;
                }
            }
            if (i == 26)
            {
                ret.push_back(s);
            }
        }
        return ret;
    }

private:
    vector<int> counter(string &word)
    {
        vector<int> count(26);
        for (char c : word)
        {
            count[c - 'a']++;
        }
        return count;
    }
};
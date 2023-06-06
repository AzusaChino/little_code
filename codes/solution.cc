#include <algorithm>
#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    string reverseWords(string s)
    {
        reverse(s.begin(), s.end());
        int i = 0, j = 0, n = s.size(), last_index = 0;

        while (j < n)
        {
            // skip prefix spaces ???
            while (j < n && s[j] == ' ')
                j++;

            int start_index = i;

            // store the complete word
            while (j < n && s[j] != ' ')
            {
                s[i++] = s[j++];
                last_index = i;
            }

            // reverse the word
            reverse(s.begin() + start_index, s.begin() + last_index);
            s[i++] = ' ';
        }
        // skip suffix spaces ???
        s.resize(last_index);

        return s;
    }

    vector<vector<string>> suggestedProducts(vector<string> &products,
                                             string searchWord)
    {
        sort(products.begin(), products.end());
        vector<vector<string>> ret;
        int start;
        int last_start_ = 0, N = products.size();

        string prefix;

        for (char &c : searchWord)
        {
            prefix += c;
            ret.push_back({});

            start = lower_bound(products.begin() + last_start_, products.end(), prefix) - products.begin();
            for (int i = start; i < min(start + 3, N) && !products[i].compare(0, prefix.size(), prefix); i++)
            {
                ret.back().push_back(products[i]);
            }

            last_start_ = start;
        }

        return ret;
    }
};
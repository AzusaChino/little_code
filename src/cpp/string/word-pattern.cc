#include <vector>
#include <string>
#include <sstream>
#include <map>
#include <set>

using namespace std;

class Solution
{
public:
    bool wordPattern(string pattern, string s)
    {
        map<char, string> mp;
        set<string> st;
        auto sz = pattern.size();
        vector<string> v;

        // separate string with whitespaces
        stringstream ss(s);
        string word;
        while (ss >> word)
            v.push_back(word);

        // if data is insufficient
        if (v.size() != pattern.size())
            return false;

        for (auto i = 0; i < sz; i++)
        {
            if (mp.find(pattern[i]) != mp.end())
            {
                if (mp[pattern[i]] != v[i])
                {
                    return false;
                }
            }
            else
            {
                // if any of the alphabet haven't matched with string
                // "abba" "dog dog dog dog"
                if (st.count(v[i]) > 0)
                {
                    return false;
                }
                mp.insert(std::make_pair(pattern[i], v[i]));
                st.insert(v[i]);
            }
        }
        return true;
    }
};
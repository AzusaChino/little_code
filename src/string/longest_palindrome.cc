#include <string>

using namespace std;

string longestPalindrome(string s)
{
    string ret;
    for (size_t i = 0; i < s.size(); i++)
    {
        string a = helper(s, i, i);
        string b = helper(s, i, i + 1);
        ret = ret.size() > a.size() ? ret : a;
        ret = ret.size() > b.size() ? ret : b;
    }
    return ret;
}

string helper(string &s, int l, int r)
{
    while (l >= 0 && r < s.size() && s[l] == s[r])
    {
        l++;
        r--;
    }
    return s.substr(l + 1, r - l - 1);
}
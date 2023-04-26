#include <string>
#include <unordered_map>
#include <climits>
#include <vector>

using namespace std;

string min_window(string s, string t)
{
    unordered_map<char, int> need, window;
    for (char c : t)
    {
        need[c]++;
    }

    int l = 0, r = 0;
    int valid_cnt = 0;

    int start = 0, len = INT_MAX;
    while (r < s.length())
    {
        char c = s[r];
        r++;
        if (need.count(c))
        {
            window[c]++;
            if (window[c] == need[c])
            {
                valid_cnt++;
            }
        }
        while (valid_cnt == need.size())
        {
            if (r - l < len)
            {
                start = l;
                len = r - l;
            }
            char d = s[l];
            l++;
            if (need.count(d))
            {
                if (window[d] == need[d])
                {
                    valid_cnt--;
                }
                window[d]--;
            }
        }
    }

    if (len == INT_MAX)
    {
        return "";
    }
    else
    {
        return s.substr(start, len);
    }
}

bool check_inclusion(string s, string t)
{
    unordered_map<char, int> window, need;
    for (char c : t)
    {
        need[c]++;
    }

    int l = 0, r = 0, valid = 0;
    while (r < s.size())
    {
        char c = s[r];
        r++;
        if (need.count(c))
        {
            window[c]++;
            if (window[c] == need[c])
            {
                valid++;
            }
        }

        while (r - l >= t.size())
        {
            if (valid == t.size())
            {
                return true;
            }
            char d = s[l];
            l++;
            if (need.count(d))
            {
                if (window[d] == need[d])
                {
                    valid--;
                }
                window[d]--;
            }
        }
    }

    return false;
}

vector<int> findAnagrams(string s, string t)
{
    unordered_map<char, int> need, window;
    for (char c : t)
    {
        need[c]++;
    }
    int l = 0, r = 0;
    int valid = 0;
    vector<int> v;
    while (r < s.size())
    {
        char c = s[r];
        r++;
        if (need.count(c))
        {
            window[c]++;
            if (window[c] == need[c])
            {
                valid++;
            }
        }

        while (r - l >= t.size())
        {
            if (valid == t.size())
            {
                v.push_back(l);
            }
            char d = s[l];
            l++;
            if (need.count(d))
            {
                if (need[d] == window[d])
                {
                    valid--;
                }
                window[d]--;
            }
        }
    }
    return v;
}

int length_of_longest_sub_string(string t)
{
    unordered_map<char, int> window;

    int l = 0, r = 0;
    int ret = 0;

    while (r < t.size())
    {
        char c = t[r];
        r++;
        window[c]++;

        while (window[c] > 1)
        {
            char d = t[l];
            l++;
            window[d]--;
        }
        ret = max(ret, r - l);
    }

    return ret;
}
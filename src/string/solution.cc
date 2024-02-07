#include <string>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution
{
public:
    int firstUniqChar(string s)
    {
        unordered_map<char, pair<int, int>> m;
        int idx = s.size();
        for (int i = 0; i < s.size(); i++)
        {
            m[s[i]].first++;
            m[s[i]].second = i;
        }
        for (const auto &[c, p] : m)
        {
            if (p.first == 1)
            {
                idx = min(idx, p.second);
            }
        }
        return idx == s.size() ? -1 : idx;
    }

    string frequencySort(string s)
    {
        unordered_map<char, int> m;
        for (int i = 0; i < s.size(); i++)
        {
            m[s[i]]++;
        }

        auto cmp = [](pair<char, int> &p1, pair<char, int> &p2)
        { return p1.second < p2.second; };
        priority_queue<pair<char, int>, vector<pair<char, int>>, decltype(cmp)> pq(cmp);

        for (auto &entry : m)
        {
            pq.push(entry);
        }

        string res = "";
        while (!pq.empty())
        {
            auto entry = pq.top();
            pq.pop();
            res += string(entry.second, entry.first);
        }
        return res;
    }
};
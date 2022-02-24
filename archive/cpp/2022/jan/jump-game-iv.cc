#include <queue>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    int minJumps(vector<int> &arr)
    {
        size_t sz = arr.size();
        unordered_map<int, vector<int>> indicesOfValue;
        for (int i = 0; i < sz; ++i)
        {
            indicesOfValue[arr[i]].push_back(i);
        }
        vector<bool> visited(sz);
        visited[0] = true;
        queue<int> q;
        q.push(0);
        int step = 0;
        while (!q.empty())
        {
            for (int size = q.size(); size > 0; --size)
            {
                int i = q.front();
                q.pop();
                if (i == sz - 1)
                {
                    return step;
                }
                vector<int> &next = indicesOfValue[arr[i]];
                next.push_back(i - 1);
                next.push_back(i + 1);
                for (int j : next)
                {
                    if (j >= 0 && j < sz && !visited[j])
                    {
                        visited[j] = true;
                        q.push(j);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }
};
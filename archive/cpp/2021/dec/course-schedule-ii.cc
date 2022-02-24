#include <queue>
#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites)
    {
        vector<int> res;
        vector<int> in_degree(numCourses, 0);
        vector<vector<int>> graph(numCourses, vector<int>());

        for (auto p : prerequisites)
        {
            graph[p[1]].push_back(p[0]);
            in_degree[p[0]]++;
        }

        queue<int> que;
        for (size_t i = 0; i < in_degree.size(); ++i)
        {
            if (in_degree[i] == 0)
            {
                que.push(i);
            }
        }

        while (!que.empty())
        {
            int u = que.front();
            que.pop();
            res.push_back(u);
            for (auto v : graph[u])
            {
                in_degree[v]--;
                if (in_degree[v] == 0)
                {
                    que.push(v);
                }
            }
        }
        if (res.size() == numCourses)
        {
            return res;
        }
        else
        {
            return vector<int>();
        }
    }
};
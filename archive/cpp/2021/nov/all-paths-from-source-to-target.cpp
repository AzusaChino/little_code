#include <vector>

using namespace std;

class Solution
{
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>> &graph)
    {
        vector<vector<int>> paths;
        vector<int> path;
        dfs(graph, paths, path, 0);
        return paths;
    }

private:
    void dfs(vector<vector<int>> &g, vector<vector<int>> &res, vector<int> &path, int cur)
    {
        path.push_back(cur);
        if (cur == g.size() - 1)
        {
            res.push_back(path);
        }
        else
        {
            for (auto it : g[cur])
            {
                dfs(g, res, path, it);
            }
        }
        path.pop_back();
    }
};
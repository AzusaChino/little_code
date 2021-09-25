#include "vector"
#include "queue"

using namespace std;

class Solution
{
public:
    int shortestPath(vector<vector<int>> &grid, int k)
    {
        int m = grid.size(), n = grid[0].size();
        vector<vector<vector<bool>>> seen(m, vector<vector<bool>>(n, vector<bool>(k + 1, false)));

        queue<int> qr, qc, removed;
        qr.push(0);
        qc.push(0);
        removed.push(grid[0][0]);
        seen[0][0][0] = true;
        int offset[] = {0, -1, 0, 1, 0};
        int steps = 0;
        while (!qr.empty())
        {
            int sz = qr.size();
            for (int x = 0; x < sz; x++)
            {
                int r = qr.front();
                qr.pop();
                int c = qc.front();
                qc.pop();
                int obs = removed.front();
                removed.pop();
                if (r == m - 1 && c == n - 1)
                    return steps;
                for (int i = 0; i < 4; i++)
                {
                    int rr = r + offset[i];
                    int cc = c + offset[i + 1];
                    if (rr < 0 || rr >= m || cc < 0 || cc >= n || obs + grid[r][c] > k || seen[rr][cc][obs + grid[r][c]])
                        continue;
                    seen[rr][cc][obs + grid[r][c]] = true;
                    qr.push(rr);
                    qc.push(cc);
                    removed.push(obs + grid[r][c]);
                }
            }
            steps++;
        }
        return -1;
    }
};
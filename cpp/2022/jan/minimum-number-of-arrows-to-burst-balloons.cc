#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

class Solution
{
public:
    int findMinArrowShots(vector<vector<int>> &points)
    {
        int count = 0, arrow = INT_MIN;
        sort(points.begin(), points.end(), [](vector<int> &a, vector<int> &b)
             { return a[1] == b[1] ? a[0] < b[0] : a[1] < b[1]; });
        for (int i = 0; i < points.size(); ++i)
        {
            if (arrow != INT_MIN && points[i][0] <= arrow)
            {
                continue;
            }
            arrow = points[i][1];
            count++;
        }
        return count;
    }
};
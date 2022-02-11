#include <vector>

using namespace std;

class Solution
{
public:
    int maximalRectangle(vector<vector<char>> &matrix)
    {
        if (matrix.empty())
        {
            return 0;
        }
        const size_t m = matrix.size();
        const size_t n = matrix[0].size();
        int left[n], right[n], height[n];

        fill_n(left, n, 0);
        fill_n(right, n, n);
        fill_n(height, n, 0);

        int max_ = 0;
        for (auto i = 0; i < m; ++i)
        {
            int cur_left = 0, cur_right = n;
            for (auto j = 0; j < n; ++j)
            { // compute height (can do this from either side)
                if (matrix[i][j] == '1')
                {
                    height[j]++;
                }
                else
                {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++)
            { // compute left (from left to right)
                if (matrix[i][j] == '1')
                    left[j] = max(left[j], cur_left);
                else
                {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--)
            { // compute right (from right to left)
                if (matrix[i][j] == '1')
                    right[j] = min(right[j], cur_right);
                else
                {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++)
            { // compute the area of rectangle (can do this from either side)
                max_ = max(max_, (right[j] - left[j]) * height[j]);
            }
        }
        return max_;
    }
};
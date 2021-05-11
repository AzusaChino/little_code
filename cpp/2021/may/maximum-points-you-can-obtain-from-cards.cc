#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

class Solution
{
public:
    int _maxScore(vector<int> &cardPoints, int k)
    {
        auto i = cardPoints.begin(), j = cardPoints.end();
        int n = cardPoints.size();
        int total = accumulate(i, j, 0);
        k = n - k;
        int ans = 0;
        for (int o = 0; o <= k; o++)
        {
            auto t = max(cardPoints.begin() + o, cardPoints.begin() + k);
            ans = *t;
        }
        return ans;
    }

    int maxScore(vector<int> &cardPoints, int k)
    {
        int n = cardPoints.size(),
            i = 0,
            j = n - k;
        auto total = accumulate(cardPoints.begin() + j, cardPoints.end(), 0), best = total;
        while (k--)
        {
            best = max(best, total += cardPoints[i++] - cardPoints[j++]);
        }
        return best;
    }
};
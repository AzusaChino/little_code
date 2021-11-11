#include <vector>

using namespace std;

class Solution
{
public:
    int minStartValue(vector<int> &nums)
    {
        int minValue = 0, total = 0;
        for (int num : nums)
        {
            total += num;
            minValue = min(minValue, total);
        }
        return -minValue + 1;
    }
};
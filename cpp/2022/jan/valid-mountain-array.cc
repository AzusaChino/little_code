#include <vector>

using namespace std;

class Solution
{
public:
    bool validMountainArray(vector<int> &arr)
    {
        size_t sz = arr.size();
        int i = 0, j = sz - 1;
        while (i + 1 < sz && arr[i] < arr[i + 1])
        {
            i++;
        }

        while (j > 0 && arr[j - 1] > arr[j])
        {
            j--;
        }

        return i > 0 && j < sz - 1 && i == j;
    }
};
class Solution
{
public:
    int smallestRepunitDivByK(int k)
    {
        for (int r = 0, n = 1; n <= k; ++n)
        {
            if ((r = (r * 10 + 1) % k) == 0)
            {
                return n;
            }
        }
        return -1;
    }
};
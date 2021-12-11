class Solution
{
public:
    int nthMagicalNumber(int n, int a, int b)
    {
        long lcm = a * b / __gcd(a, b), l = 2, r = 1e14, mod = 1e9 + 7;

        while (l < r)
        {
            long m = (l + r) / 2;
            if (m / a + m / b - m / lcm < n)
            {
                l = m + 1;
            }
            else
            {
                r = m;
            }
        }
        return l % mod;
    }
};
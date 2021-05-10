#include <vector>

using namespace std;

class Solution
{
public:
    // TLE solution BF
    int countPrimes(int n)
    {
        int count = 0;
        for (int i = 0; i <= n; ++i)
        {
            if (isPrime(i))
            {
                count++;
            }
        }
        return count;
    }

    bool isPrime(int n)
    {
        if (n == 0 || n == 1)
        {
            return false;
        }
        for (int i = 2; i <= n / 2; ++i)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

private:
    int _countPrimes(int n)
    {
        int count = 0;
        vector<bool> sieve(n, true);
        for (int i = 2; i < n; i++)
        {
            if (sieve[i])
            {
                count++;
                int k = 2;
                while (k * i < n)
                {
                    sieve[k * i] = false;
                    k++;
                }
            }
        }
        return count;
    }
};
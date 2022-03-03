#include <stdio.h>

int numberOfArithmeticSlices(int *nums, int numsSize)
{
    if (numsSize < 2)
    {
        return 0;
    }
    int i;
    int cur = 0;
    int sum = 0;
    for (i = 0; i < numsSize - 2; ++i)
    {
        if (*(nums + i + 2) - *(nums + i + 1) == *(nums + i + 1) - *(nums + i))
        {
            ++cur;
        }
        else
        {
            cur = 0;
        }
        sum += cur;
    }
    return sum;
}
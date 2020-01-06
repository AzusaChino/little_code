import math


def gerPermutation(n, k):
    nums = [_ for _ in range(1, n + 1)]
    permutation = ''
    k -= 1
    while n > 0:
        n -= 1
        index, k = divmod(k, math.factorial(n))
        permutation += str(nums[index])
        nums.remove(nums[index])
    return permutation


if __name__ == '__main__':
    gerPermutation(4, 12)

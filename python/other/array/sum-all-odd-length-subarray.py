def sum1(A):
    n = len(A)
    ret = 0
    for l in range(1, n + 1, 2):
        for i in range(n - l + 1):
            ret += sum(A[i:i + 1])
    return ret


def sumOddLengthSubarrays(self, A):
    return sum(sum(A[i:i + l]) for l in range(1, 100, 2) for i in range(len(A) - l + 1))

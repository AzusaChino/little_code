class Solution:
    def smallestRange(self, A, K):
        A = sorted(A)
        result = A[-1] - A[0]
        left_min = A[0] + K
        right_max = A[-1] - K
        for i in range(len(A) - 1):
            lower = min(left_min, A[i + 1] - K)
            uppper = max(right_max, A[i] + K)
            result = min(uppper - lower, result)
        return result

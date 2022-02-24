from typing import List


def sort_array_by_parity(A: List[int]) -> List[int]:
    return sorted(A, key=lambda x: x & 1)


def sortArrayByParityII(A):
    l, r = 0, 1
    while l < len(A):
        if A[l] & 1:
            A[l], A[r], r = A[r], A[l], r + 2
        else:
            l += 2
    return A

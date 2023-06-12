from bisect import bisect_left


def binary_search(arr, t) -> int:
    if not arr:
        return -1
    l, r = 0, len(arr)
    while l <= r:
        m = l + (r - l) // 2
        if arr[m] > t:
            r = m
        elif arr[m] < t:
            l = m + 1
        else:
            return m
    return l


def a_bisect_left(arr, t) -> int:
    l, r = 0, len(arr)
    while l < r:
        m = l + (r - l) // 2
        if arr[m] < t:
            l = m + 1
        else:
            r = m
    return l


def a_bisect_right(arr, t) -> int:
    l, r = 0, len(arr)
    while l < r:
        m = l + (r - l) // 2
        if arr[m] > t:
            r = m
        else:
            l = m + 1
    return l

def solution(s, arr):
    window = 0
    N = len(arr)
    l = r = 0
    ml = 0
    ret = [0, 0]
    while r < N:
        rd = arr[r]
        r += 1
        window += rd

        while window >= s:
            if window == s:
                if ml < (r - l):
                    ml = r - l
                break
            else:
                ld = arr[l]
                l += 1
                window -= ld

    return ret


print(solution(12, [1, 2, 3, 7, 5]))

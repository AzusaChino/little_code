from typing import List


def generate_parentheses(n: int) -> List[str]:
    ret = []
    track = []
    back_track(ret, n, n, track)
    return ret


def back_track(ret: List[str], l: int, r: int, track: List[str]):
    if l < 0 or r < 0:
        return
    # mis-form
    if l > r:
        return
    if l == 0 and r == 0:
        ret.append("".join(track))
        return
    track.append("(")
    back_track(ret, l - 1, r, track)
    track.pop()
    track.append(")")
    back_track(ret, l, r - 1, track)
    track.pop()


def subset(nums: List[int]) -> List[List[int]]:
    def helper(ret, nums, start, track):
        ret.append(track[:])
        for i in range(start, len(nums)):
            track.append(nums[i])
            helper(ret, nums, i + 1, track)
            track.pop()

    ret = []
    track = []
    helper(ret, nums, 0, track)
    return ret


def combination(n: int, k: int) -> List[List[int]]:
    ret = []

    def helper(n, k, start, track):
        if len(track) == k:
            ret.append(track[:])
            return
        for i in range(start, n + 1):
            track.append(i)
            helper(n, k, i + 1, track)
            track.pop()

    track = []

    helper(n, k, 0, track)

    return ret


def permutation(nums: List[int]) -> List[List[int]]:
    ret = []

    def backtrack(nums, track):
        if len(track) == len(nums):
            ret.append(track[:])
            return
        for i in nums:
            if i in track:
                continue
            track.append(i)
            backtrack(nums, track)
            track.pop()

    track = []
    backtrack(nums, track)
    return ret


if __name__ == "__main__":
    print(generate_parentheses(3))
    print(subset([1, 2, 3]))
    print(combination(4, 2))
    print(permutation([1, 2, 3]))

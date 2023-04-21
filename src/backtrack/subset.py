from typing import List


def subset(nums: List[int]) -> List[List[int]]:
    ret = []

    def backtrack(nums, start, temp: List[int]):
        ret.append(temp[:])
        for i in range(start, len(nums)):
            temp.append(nums[i])
            backtrack(nums, i + 1, temp)
            temp.pop()

    backtrack(nums, 0, [])
    return ret


def main():
    print(subset([1, 2, 3]))


if __name__ == "__main__":
    main()

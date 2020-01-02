def canJump(nums) -> bool:
    farthest = nums[0]
    for i, n in enumerate(nums):
        if i <= farthest < n + i:
            farthest = n + i
    return farthest >= len(nums) - 1


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4, 5]
    nums2 = [4, 2, 1, 0, 0, 1]
    print(canJump(nums1))
    print(canJump(nums2))

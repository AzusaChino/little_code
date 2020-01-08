def remove(nums: list, val: int) -> int:
    j = 0
    for i in range(len(nums)):
        if val is not nums[i]:
            nums[j] = nums[i]
            j += 1
    return j

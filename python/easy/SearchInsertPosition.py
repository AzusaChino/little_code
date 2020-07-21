def search(nums: list, target: int) -> int:
    for x in range(len(nums)):
        if target <= nums[x]:
            return x

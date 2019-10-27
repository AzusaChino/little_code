def remove(nums: list) -> int:
    i = 0
    for j in range(1, len(nums)):
        if nums[i] != nums[j]:
            i += 1
            nums[i] = nums[j]
    return i + 1


if __name__ == '__main__':
    print(remove([1, 2, 2, 2, 2, 3, 4, 5]))

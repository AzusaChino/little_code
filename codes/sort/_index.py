def bubble_sort(nums):
    for i in range(0, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] > nums[j]:
                nums[i], nums[j] = nums[j], nums[i]
    return nums


def insertion_sort(nums):
    for i in range(1, len(nums)):
        val = nums[i]
        # start with the previous one
        j = i - 1
        while j >= 0 and nums[j] > val:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = val
    return nums


def selection_sort(nums):
    for i in range(0, len(nums) - 1):
        minimum = i
        for j in range(i + 1, len(nums)):
            if nums[minimum] > nums[j]:
                minimum = j
        nums[i], nums[minimum] = nums[minimum], nums[i]
    return nums


def merge_sort(nums):
    def merge(arr1, arr2):
        ret = []
        i, j, il, jl = 0, 0, len(arr1), len(arr2)
        while i < il and j < jl:
            if arr1[i] > arr2[j]:
                ret.append(arr2[j])
                j += 1
            else:
                ret.append(arr1[i])
                i += 1
        while i < il:
            ret.append(arr1[i])
            i += 1
        while j < jl:
            ret.append(arr2[j])
            j += 1
        return ret

    if len(nums) <= 1:
        return nums
    m = len(nums) // 2
    left_side = merge_sort(nums[:m])
    right_side = merge_sort(nums[m:])
    return merge(left_side, right_side)


def quick_sort_not_friendly(nums):
    if len(nums) <= 1:
        return nums
    pivot = nums[len(nums) // 2]
    left = [x for x in nums if x < pivot]
    middle = [x for x in nums if x == pivot]
    right = [x for x in nums if x > pivot]
    return quick_sort_not_friendly(left) + middle + quick_sort_not_friendly(right)


def quick_sort(nums):
    def helper(nums, low, high):
        if low >= high:
            return

        pivot = partition(nums, low, high)
        helper(nums, low, pivot - 1)
        helper(nums, pivot + 1, high)

    def partition(nums, low, high):
        i = low - 1
        pivot = nums[high]
        for j in range(low, high):
            if nums[j] <= pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1], nums[high] = nums[high], nums[i + 1]
        return i + 1

    helper(nums, 0, len(nums) - 1)
    return nums


if __name__ == "__main__":
    nums = [5, 3, 2, 4, 1]

    print(bubble_sort(nums[:]))
    print(insertion_sort(nums[:]))
    print(selection_sort(nums[:]))
    print(merge_sort(nums[:]))
    print(quick_sort(nums[:]))

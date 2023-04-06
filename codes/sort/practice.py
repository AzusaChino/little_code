def bubble_sort(nums):
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] > nums[j]:
                nums[i], nums[j] = nums[j], nums[i]


def insertion_sort(nums):
    for i in range(1, len(nums)):
        val = nums[i]
        j = i - 1
        while j >= 0 and nums[j] > val:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = val
    return nums


def selection_sort(nums):
    for i in range(len(nums)):
        minimum = nums[i]
        for j in range(i + 1, len(nums)):
            if nums[minimum] > nums[j]:
                minimum = j
        nums[i], nums[minimum] = nums[minimum], nums[i]


def merge_sort(nums):
    def merge(arr1, arr2):
        ret = [0] * (len(arr1) + len(arr2))
        i, j, k = 0, 0, 0
        while i < len(arr1) and j < len(arr2):
            if arr1[i] > arr2[j]:
                ret[k] = arr2[j]
                j += 1
            else:
                ret[k] = arr1[i]
                i += 1
            k += 1
        while i < len(arr1):
            ret[k] = arr1[i]
            i += 1
            k += 1
        while j < len(arr2):
            ret[k] = arr2[j]
            j += 1
            k += 1
        return ret

    if len(nums) <= 1:
        return nums
    m = len(nums) // 2
    left = merge_sort(nums[:m])
    right = merge_sort(nums[m:])
    return merge(left, right)


def partition(nums, l, r):
    pivot = nums[r]
    middle = l - 1
    for i in range(l, r):
        if nums[i] <= pivot:
            middle += 1
            nums[i], nums[middle] = nums[middle], nums[i]
    nums[middle + 1], nums[r] = nums[r], nums[middle + 1]
    return middle + 1


def quick_sort(nums):
    def helper(nums, l, r):
        if l >= r:
            return
        pivot = partition(nums, l, r)
        helper(nums, l, pivot - 1)
        helper(nums, pivot + 1, r)

    helper(nums, 0, len(nums - 1))

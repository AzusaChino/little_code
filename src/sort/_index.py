def bubble_sort(nums):
    if not nums:
        return
    for i in range(0, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] > nums[j]:
                nums[i], nums[j] = nums[j], nums[i]


def insertion_sort(nums):
    for i in range(1, len(nums)):
        value = nums[i]
        j = i - 1
        while j >= 0 and nums[j] > value:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = value


def selection_sort(nums):
    for i in range(0, len(nums) - 1):
        mini = i
        for j in range(i + 1, len(nums)):
            if nums[i] > nums[j]:
                mini = j
        nums[mini], nums[i] = nums[i], nums[mini]


# def merge_sort(nums):

#     if len(nums) <= 1:
#         return nums
#     mid = len(nums) // 2
#     left = merge_sort(nums[:mid])
#     right = merge_sort(nums[mid:])
#     return merge(left, right)


def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        i = j = k = 0

        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1


def partition(nums, l, r):
    if l >= r:
        return
    pivot = nums[r]
    # indicates no smaller element yet
    index = l - 1
    for i in range(l, r):
        if nums[i] <= pivot:
            index += 1
            nums[index], nums[i] = nums[i], nums[index]
    # move pivot to the middle
    nums[index + 1], nums[r] = nums[r], nums[index + 1]
    return index + 1


def quick_sort(nums):
    def helper(nums, l, r):
        if l >= r:
            return nums
        p = partition(nums, l, r)
        helper(nums, l, p - 1)
        helper(nums, p + 1, r)

    helper(nums, 0, len(nums) - 1)


def question_1846(arr):
    # quirky problem, simply considering the restriction, not the input data
    arr.sort()
    pre = 0
    for n in arr:
        pre = min(pre + 1, n)
    return pre


from itertools import accumulate

if __name__ == "__main__":
    nums = [2, 3, 1, 5, 4, 0]
    # quick_sort(nums)

    print(list(accumulate(nums)))

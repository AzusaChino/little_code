from typing import List


def sortColors(nums: List):
    red, white, blue = 0, 0, len(nums) - 1
    while white <= blue:
        if nums[white] == 0:
            nums[red], nums[white] = nums[white], nums[red]
            red += 1
            white += 1
        elif nums[white] == 1:
            white += 1
        else:
            nums[white], nums[blue] = nums[blue], nums[white]
            blue -= 1


if __name__ == '__main__':
    nums = [2, 1, 2, 2, 2, 1, 0]
    sortColors(nums)
    print(nums)

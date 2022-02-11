from typing import List


def find_dup(nums: List[int]) -> int:
    tortoise, hare = nums[0], nums[0]
    # 快慢指针
    while True:
        tortoise, hare = nums[tortoise], nums[nums[hare]]
        if tortoise == hare:
            break
    ptr1, ptr2 = nums[0], tortoise
    while ptr1 != ptr2:
        ptr1, ptr2 = nums[ptr1], nums[ptr2]
    return ptr1


if __name__ == '__main__':
    print(find_dup([1, 2, 3, 3]))

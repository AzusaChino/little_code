#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#

# @lc code=start
class Solution:
    def rotate0(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k < 1: pass
        elif k % len(nums) == 0: pass
        k = k % len(nums)
        for i in range(k):
            pass
    def rotate1(self, nums: List[int], k:int) -> None:
        for _ in range(k):
            pre = nums[-1]
            for i in range(len(nums)):
                temp = nums[i]
                nums[i] = pre
                pre = temp
    def rotate2(self, nums: List[int], k:int) -> None:
        a = [0] * len(nums)
        for i in range(len(nums)):
            a[(i+k) % len(nums)] = nums[i]
        for i in range(len(nums)):
            nums[i] = a[i]
    def rotat3(self, nums: List[int], k:int) -> None:
        length = len(nums)
        k %= length
        count, start = 0, 0
        while count < length:
            current = start
            pre = nums[start]
            while True:
                next = (current + k) % length
                temp = nums[next]
                nums[next] = pre
                pre = temp
                current = next
                count +=1
                if start == current:
                    break
            start += 1
    def rotate(self, nums: List[int], k:int) -> None:
        k %= len(nums)
        self.reverse(nums, 0, len(nums)-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums)-1)
    def reverse(self, nums, start, end):
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start +=1
            end -=1
# @lc code=end


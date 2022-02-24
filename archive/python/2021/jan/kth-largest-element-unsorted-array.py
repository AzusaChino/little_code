import random

class Solution:
    def getKthLargest(self, nums, k):
        k = len(nums) - k
        l,r = 0, len(nums) -1
        while True:
            index = self.partition(nums, l,r )
            if index == k:
                return nums[index]
            if index > k:
                r = index -1
            else:
                l = index+1
    def partition(self, nums, l ,r):
        rand_index = random.randint(l,r)
        rand_entry = nums[rand_index]
        next_lower = l
        for i in range(l,r):
            if nums[i] <= rand_entry:
                nums[next_lower], nums[i] = nums[i], nums[next_lower]
                next_lower+=1
        nums[next_lower] ,nums[r] = nums[r], nums[next_lower]
        return next_lower
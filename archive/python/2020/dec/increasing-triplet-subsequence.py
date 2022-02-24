class Solution:
    def increasingTriplet(self, nums):
        smallest, next_smallest = float('inf'), float('inf')
        for n in nums:
            smallest = min(smallest, n)
            if n > smallest:
                next_smallest = min(next_smallest, n)
            if n > next_smallest:
                return True
        return False

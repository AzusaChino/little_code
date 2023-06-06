from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        """
        27 - two pointer
        """
        N = len(nums)
        slow, fast = 0, 0
        while fast < N:
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow

    def removeDuplicates(self, nums: List[int]) -> int:
        """
        26 - two pointer
        """
        N = len(nums)
        s, f = 0, 0
        while f < N:
            if nums[s] != nums[f]:
                s += 1
                nums[s] = nums[f]
            f += 1
        return s + 1

    def removeDuplicates_(self, nums: List[int]) -> int:
        """
        80 - two pointer
        """
        # i = 0
        # for n in nums:
        #     if i < 2 or n > nums[i - 2]:
        #         nums[i] = n
        #         i += 1
        # print(nums)
        # return i
        N = len(nums)
        s, f = 2, 2
        while f < N:
            if nums[s - 2] != nums[f]:
                nums[s] = nums[f]
                s += 1
            f += 1
        return s

    def rotate(self, nums: List[int], k: int) -> None:
        """
        189. Rotate Array
        """

        def helper(nums, l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1

        N = len(nums)
        k = k % N
        helper(nums, 0, N - 1)
        helper(nums, 0, k - 1)
        helper(nums, k, N - 1)

    def isPalindrome(self, s: str) -> bool:
        N = len(s)
        l, r = 0, N - 1
        while l < r:
            if s[l].isalnum() and s[r].isalnum():
                if s[l].lower() != s[r].lower():
                    return False
                else:
                    l += 1
                    r -= 1
            elif s[l].isalnum():
                r -= 1
            elif s[r].isalnum():
                l += 1
            else:
                l += 1
                r -= 1
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.removeDuplicates_([0, 0, 1, 1, 1, 1, 2, 3, 3]))

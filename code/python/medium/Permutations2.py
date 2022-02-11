from collections import Counter
from functools import reduce


class Solution:
    def permuteUnique(self, nums):
        ans = [[]]
        for n in nums:
            new_ans = []
            for l in ans:
                for i in range(len(l) + 1):
                    new_ans.append(l[:i] + [n] + l[i:])
                    if i < len(l) and l[i] == n: break  # handles duplication
            ans = new_ans
        return ans

    def permuteUnique2(self, nums):
        def btrack(path, counter):
            if len(path) == len(nums):
                ans.append(path[:])
            for x in counter:  # dont pick duplicates
                if counter[x] > 0:
                    path.append(x)
                    counter[x] -= 1
                    btrack(path, counter)
                    path.pop()
                    counter[x] += 1

        ans = []
        btrack([], Counter(nums))
        return ans

    def permuteUnique3(self, nums):
        return reduce(lambda a,n:[l[:i]+[n]+l[i:]for l in a for i in range((l+[n]).index(n)+1)],nums,[[]])


if __name__ == '__main__':
    s = Solution()
    print(s.permuteUnique([1, 2, 1]))
    print(s.permuteUnique3([1, 2, 1,1]))

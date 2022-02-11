from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def dfs(lst, temp, nums, visited):
            if len(temp) == len(nums):
                lst.append(temp[:])
            else:
                for i in range(len(nums)):
                    if visited[i] or (i > 0 and not visited[i - 1] and nums[i] == nums[i - 1]):
                        continue
                    visited[i] = True
                    temp.append(nums[i])
                    dfs(lst, temp, nums, visited)
                    temp = temp[:-1]
                    visited[i] = False

        lst = []
        nums.sort()
        dfs(lst, [], nums, [False] * len(nums))
        return lst


if __name__ == '__main__':
    print(Solution().permuteUnique([1,1,2]))

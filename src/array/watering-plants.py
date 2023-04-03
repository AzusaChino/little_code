from typing import List


class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        ans = 0
        can = capacity
        for i, x in enumerate(plants):
            # cap is granted greater than any plant
            if can < x:
                ans += 2*i
                can = capacity
            ans += 1
            can -= x
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.wateringPlants([1, 1, 1, 4, 2, 3], 4))

from typing import List


class Solution:
    def pancakeSort(self, cakes: List[int]) -> List[int]:
        # 记录反转操作序列
        self.res = []
        self.sort(cakes, len(cakes))
        return self.res

    def sort(self, cakes: List[int], n: int) -> None:
        # base case
        if n == 1:
            return
        # 寻找最大饼的索引
        max_cake = 0
        max_cake_index = 0
        for i in range(n):
            if cakes[i] > max_cake:
                max_cake_index = i
                max_cake = cakes[i]
        # 第一次翻转，将最大饼翻到最上面
        self.reverse(cakes, 0, max_cake_index)
        self.res.append(max_cake_index + 1)
        # 第二次翻转，将最大饼翻到最下面
        self.reverse(cakes, 0, n - 1)
        self.res.append(n)

        # 递归调用
        self.sort(cakes, n - 1)

    def reverse(self, arr: List[int], i: int, j: int) -> None:
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1


if __name__ == "__main__":
    s = Solution()
    nums = [3, 2, 4, 1]
    print(s.pancakeSort(nums))
    print(nums)

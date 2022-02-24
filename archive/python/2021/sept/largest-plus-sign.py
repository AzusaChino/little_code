class Solution:
    def orderOfLargestPlusSign(self, n, mines):
        """
        :type N: int
        :type mines: List[List[int]]
        :rtype: int
        """
        grid = [[n] * n for i in range(n)]

        for m in mines:
            grid[m[0]][m[1]] = 0

        for i in range(n):
            l, r, u, d = 0, 0, 0, 0

            for j, k in zip(range(n), reversed(range(n))):
                l = l + 1 if grid[i][j] != 0 else 0
                if l < grid[i][j]:
                    grid[i][j] = l

                r = r + 1 if grid[i][k] != 0 else 0
                if r < grid[i][k]:
                    grid[i][k] = r

                u = u + 1 if grid[j][i] != 0 else 0
                if u < grid[j][i]:
                    grid[j][i] = u

                d = d + 1 if grid[k][i] != 0 else 0
                if d < grid[k][i]:
                    grid[k][i] = d

        res = 0

        for i in range(n):
            for j in range(n):
                if res < grid[i][j]:
                    res = grid[i][j]

        return res

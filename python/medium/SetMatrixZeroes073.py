"""
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

- A straight forward solution using O(mn) space is probably a bad idea.
- A simple improvement uses O(m + n) space, but still not the best solution.
- Could you devise a constant space solution?

"""

from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        def setRowZeros(matrix: List[List[int]], i: int) -> None:
            C = len(matrix[0])
            matrix[i] = [0] * C

        def setColZeros(matrix: List[List[int]], j: int) -> None:
            R = len(matrix)
            for i in range(R):
                matrix[i][j] = 0

        isCol = False
        R = len(matrix)
        C = len(matrix[0])

        for i in range(R):
            if matrix[i][0] == 0:
                isCol = True
            for j in range(1, C):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for j in range(1, C):
            if matrix[0][j] == 0:
                setColZeros(matrix, j)

        for i in range(R):
            if matrix[i][0] == 0:
                setRowZeros(matrix, i)

        if isCol:
            setColZeros(matrix, 0)


if __name__ == '__main__':
    matrix = [[1, 2, 3], [3, 2, 1], [2, 0, 3]]

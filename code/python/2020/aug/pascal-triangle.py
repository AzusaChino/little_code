def generate(numRows):
    res = [[1]]
    for i in range(1, numRows):
        res += [map(lambda x, y: x + y, res[-1] + [0], [0] + res[-1])]
    return res[:numRows]


class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        row = [1]
        for _ in range(rowIndex):
            row = [x + y for x, y in zip([0] + row, row + [0])]
        return row

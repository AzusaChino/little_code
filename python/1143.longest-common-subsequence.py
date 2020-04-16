#
# @lc app=leetcode id=1143 lang=python3
#
# [1143] Longest Common Subsequence
#

# @lc code=start
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        matrix = [[0 for _ in range(len(text1)+1)] for _ in range(len(text2)+1)]
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if text1[j-1] == text2[i-1]:
                    matrix[i][j] = matrix[i-1][j-1] + 1
                else:
                    matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1])
        
        return matrix[-1][-1]
# @lc code=end


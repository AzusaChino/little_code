class Solution:
    def min_distance(self, word1, word2):
        """Naive recursive solution"""
        if not word1 and not word2:
            return 0
        if not word1:
            return len(word2)
        if not word2:
            return len(word1)
        if word1[0] == word2[0]:
            return self.min_distance(word1[1:], word2[1:])
        insert = 1 + self.min_distance(word1, word2[1:])
        delete = 1 + self.min_distance(word1[1:], word2)
        replace = 1 + self.min_distance(word1[1:], word2[1:])
        return min(insert, replace, delete)


class Solution2:
    def min_distance(self, word1, word2, i, j, memo):
        """Memoized solution"""
        if i == len(word1) and j == len(word2):
            return 0
        if i == len(word1):
            return len(word2) - j
        if j == len(word2):
            return len(word1) - i

        if (i, j) not in memo:
            if word1[i] == word2[j]:
                ans = self.min_distance(word1, word2, i + 1, j + 1, memo)
            else:
                insert = 1 + self.min_distance(word1, word2, i, j + 1, memo)
                delete = 1 + self.min_distance(word1, word2, i + 1, j, memo)
                replace = 1 + self.min_distance(word1, word2, i + 1, j + 1, memo)
                ans = min(insert, delete, replace)
            memo[(i, j)] = ans
        return memo[(i, j)]


class Solution3:
    def min_distance(self, word1, word2):
        """Dynamic programming solution"""
        m = len(word1)
        n = len(word2)
        table = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m + 1):
            table[i][0] = i
        for j in range(n + 1):
            table[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    table[i][j] = table[i - 1][j - 1]
                else:
                    table[i][j] = 1 + min(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1])
        return table[-1][-1]

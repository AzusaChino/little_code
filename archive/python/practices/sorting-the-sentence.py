import itertools

class Solution:
    def sortSentence(self, s: str) -> str:
        arr = s.split(" ")
        arr.sort(key= lambda x : x[-1])
        return " ".join(map(lambda x : x[:-1], arr))

if __name__ == '__main__':
    s = Solution()
    print(s.sortSentence("is2 sentence4 This1 a3"))
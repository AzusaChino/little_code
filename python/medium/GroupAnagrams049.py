class Solution:
    def group(self, strs):
        d = {}
        for s in strs:
            key = tuple(sorted(s))
            d[key] = d.get(key, []) + [s]
        return list(d.values())


if __name__ == '__main__':
    s = Solution()
    print(s.group(["abc", "bca", "cba", "a"]))

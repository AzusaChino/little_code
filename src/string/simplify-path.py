class Solution:
    def simplifyPath(self, path: str) -> str:
        arr = path.split("/")
        st = []
        for d in arr:
            if not d or d == ".":
                continue
            if d != "..":
                st.append(d)
            elif st:
                st.pop()
        r = ""
        for d in st:
            r += "/" + d
        if r:
            return r
        return "/"


def main():
    dir = "/home/"
    s = Solution()
    print(s.simplifyPath(dir))


if __name__ == "__main__":
    main()

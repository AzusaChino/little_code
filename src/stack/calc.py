from typing import List
import collections


def calc(q: List[str]) -> int:
    d = {
        "+": lambda x: x[0] + x[1],
        "-": lambda x: x[0] - x[1],
        "*": lambda x: x[0] * x[1],
        "/": lambda x: x[0] / x[1],
    }
    ops = []
    nums = []
    for q_ in q:
        if q_.isdigit():
            nums.append(int(q_))
        else:
            ops.append(q_)

    while len(nums) > 1:
        r = nums.pop()
        l = nums.pop()
        op = ops.pop()
        r = d[op]([l, r])
        nums.append(r)
    return nums.pop()


def caculate(s: str) -> int:
    def helper(s: collections.deque) -> int:
        st = []
        sign = "+"
        num = 0
        while s:
            # popleft
            c = s.popleft()
            if c.isdigit():
                num = 10 * num + int(c)
            if c == "(":
                num = helper(s)
            if (not c.isdigit() and not c.isspace()) or not s:
                if sign == "+":
                    st.append(num)
                elif sign == "-":
                    st.append(-num)
                elif sign == "*":
                    st[-1] = st[-1] * num
                elif sign == "/":
                    st[-1] = int(st[-1] / num)
                num = 0
                sign = c
            if c == ")":
                break
            print(num, " -> ", st)
        return sum(st)

    return helper(collections.deque(s))


if __name__ == "__main__":
    q = ["1", "+", "2"]
    print(calc(q))
    print(caculate("3 * (4-5/2)-6"))

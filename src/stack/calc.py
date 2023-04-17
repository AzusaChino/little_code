from typing import List


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


if __name__ == "__main__":
    q = ["1", "+", "2"]
    print(calc(q))

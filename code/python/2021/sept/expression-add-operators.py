class Solution(object):
    def addOperators(self, num, target):
        def backtracking(i, path, resultSoFar, prev):
            if i == len(num):
                if resultSoFar == target:
                    ans.append(path)
                return

            for j in range(i, len(num)):
                if j > i and num[i] == "0":
                    break  # Skip leading zero number
                now = int(num[i : j + 1])
                if i == 0:
                    backtracking(
                        j + 1, path + str(now), resultSoFar + now, now
                    )  # First num, pick it without adding any operator
                else:
                    backtracking(j + 1, path + "+" + str(now), resultSoFar + now, now)
                    backtracking(j + 1, path + "-" + str(now), resultSoFar - now, -now)
                    backtracking(
                        j + 1,
                        path + "*" + str(now),
                        resultSoFar - prev + prev * now,
                        prev * now,
                    )  # Can imagine with example: 1+2*3*4

        ans = []
        backtracking(0, "", 0, 0)
        return ans

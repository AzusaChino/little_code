class Solution:
    def generateParenthesis(self, n):
        def generate(p, left, right, parents=[]):
            if left:
                generate(p + "(", left - 1, right)
            if right > left:
                generate(p + ")", left, right - 1)
            if not right:
                parents += (p,)  # same for parents.append(p)
            return parents

        return generate("", n, n)

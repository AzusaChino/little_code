class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        '''
        Divide p,q by 2 until at least one odd.

        If p = odd, q = even: return 0
        If p = even, q = odd: return 2
        If p = odd, q = odd: return 1
        I summary it as return 1 - p % 2 + q % 2
        '''
        while p % 2 == 0 and q % 2 == 0: p, q = p // 2, q // 2
        return 1 - p % 2 + q % 2
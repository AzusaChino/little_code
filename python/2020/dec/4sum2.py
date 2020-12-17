from collections import defaultdict

class Solution:
    '''
    四个包含两个数的集合, 求i,j,k,l四个数和为0的count
    '''
    def fourArraySumZero(self, A, B, C, D):
        AB = defaultdict(int)
        count = 0
        for a in A:
            for b in B:
                AB[a+b] += 1
        
        for c in C:
            for d in D:
                if -(c+d) in AB:
                    count += AB[-(c+d)]
        return count
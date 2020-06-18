def numJewelsInStones(self, J, S):
    return sum(map(J.count, S))


def _numJewelsInStones(self, J, S):
    return sum(map(S.count, J))


def __numJewelsInStones(J, S):
    return sum(s in J for s in S)

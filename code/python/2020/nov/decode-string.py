import string

class Solution:
    def __init__(self):
        self.i = 0
    
    def decodeString(self, s:str) -> str:
        return "".join(self._decode(s))
    
    def _decode(self, s:str):
        ret = []
        while self.i < len(s) and s[self.i] != ']':
            if s[self.i] not in string.digits:
                ret.append(s[self.i])
                self.i += 1
            else:
                repeats = 0
                while s[self.i] in string.digits:
                    repeats = repeats * 10 + int(s[self.i])
                    self.i += 1
                self.i += 1
                ret += (self._decode(s) * repeats)
                self.i += 1
        return ret
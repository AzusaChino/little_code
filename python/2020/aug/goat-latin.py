class Solution(object):
    def goat_latin(self, s: str) -> str:
        vowels = ['a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O']

        def latin(i: int, w: str) -> str:
            if w[0] not in vowels:
                w = w[1:] + w[0]
            return w + 'ma' + 'a' * (i + 1)

        return ' '.join(latin(i, w) for i, w in enumerate(s.split()))

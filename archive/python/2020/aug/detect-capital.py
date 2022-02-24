class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return word[1:].lower() == word[1:] or word.upper() == word

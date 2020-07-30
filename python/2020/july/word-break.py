def word_break(s, words):
    ok = [True]
    for i in range(1, len(s) + 1):
        ok += any(ok[j] and s[j:i] in words for j in range(i))
    return ok[-1]


def _word_break(s, words):
    ok = [True]
    max_len = max(map(len, words + ['']))
    words = set(words)
    for i in range(1, len(s) + 1):
        ok += any(ok[j] and s[j:i] in words for j in range(max(0, i - max_len), i)),
    return ok[-1]


def word_break_2(s, word_dict):
    memo = {len(s): ['']}

    def sentences(i):
        if i not in memo:
            memo[i] = [s[i:j] + (tail and ' ' + tail)
                       for j in range(i + 1, len(s) + 1)
                       if s[i:j] in word_dict
                       for tail in sentences(j)]
        return memo[i]

    return sentences(0)

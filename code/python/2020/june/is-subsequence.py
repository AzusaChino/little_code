def is_subsequence(s: str, t: str) -> bool:
    t = iter(t)
    return all(c in t for c in s)


def _is_subsequence(s: str, t: str) -> bool:
    remainder_of_t = iter(t)
    for l in s:
        if l not in remainder_of_t:
            return False
    return True

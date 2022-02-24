from typing import List


def h_index(citations: List[int]) -> int:
    return sum(i < j for i, j in enumerate(sorted(citations, reverse=True)))

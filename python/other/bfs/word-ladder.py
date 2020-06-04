import string
from typing import List


def word_ladder(start_word: str, end_word: str, word_list: List[str]) -> int:
    if end_word not in word_list:
        return 0
    front, back = {start_word}, {end_word}
    step = 1
    word_list, word_len = set(word_list), len(start_word)

    while front and back:
        step += 1
        next_front = set()

        for word in front:
            for i in range(word_len):
                for c in string.ascii_lowercase:
                    if c != word[i]:
                        new_word = word[:i] + c + word[i + 1:]
                        if new_word in back:
                            return step
                        if new_word in word_list:
                            next_front.add(new_word)
                            word_list.remove(new_word)
        front = next_front

        if len(back) < len(front):
            back, front = front, back
    return 0

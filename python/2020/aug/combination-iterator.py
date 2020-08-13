import itertools


class CombinationIterator_(object):

    def __init__(self, *a):
        combs = map(''.join, itertools.combinations(*a))[::-1]
        self.next = combs.pop
        self.hasNext = lambda: bool(combs)


class CombinationIterator:

    def __init__(self, chars: str, comblen: int):
        self.generator = self.gen_next(chars, [], comblen, 0)
        self.last, self.end = None, chars[-comblen:]

    def gen_next(self, chars, path, coml, st):
        if coml == 0: yield ''.join(path); return
        for i in range(st, len(chars)):
            yield from self.gen_next(chars, path + [chars[i]], coml - 1, i + 1)

    def next(self) -> str:
        self.last = next(self.generator)
        return self.last

    def hasNext(self) -> bool:
        return self.last != self.end

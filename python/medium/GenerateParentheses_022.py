def gen1(n):
    def generate(p, left, right, parentheses=[]):
        if left:
            generate(p + '(', left - 1, right)
        if right > left:
            generate(p + ')', left, right - 1)
        if not right:
            parentheses += p, # ??
        return parentheses

    return generate('', n, n)


def gen2(n):
    def generate(p, l, r):
        if r >= l >= 0:
            if not r:
                yield p
            for q in generate(p + '(', l - 1, r): yield q
            for q in generate(p + ')', l, r - 1): yield q

    return list(generate('', n, n))


def gen3(n, open=0):
    if n > 0 <= open:
        return ['(' + p for p in gen3(n - 1, open + 1)] + \
               [')' + p for p in gen3(n, open - 1)]
    return [')' * open] * (not n)


if __name__ == '__main__':
    print(gen1(3))
    print(gen2(3))
    print(gen3(3))

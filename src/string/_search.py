def search(a: str, b: str) -> bool:
    if (not a or not b) or (len(a) < len(b)):
        return False
    for i in range(len(a) - len(b) + 1):
        if a[i] == b[0]:
            find = True
            for j in range(1, len(b)):
                if a[i + j] != b[j]:
                    find = False
                    break
            if find:
                return True

        else:
            continue

    return False


def search_rk(a: str, b: str) -> bool:
    if (not a or not b) or (len(a) < len(b)):
        return False
    hb = hash(b)
    for i in range(len(a) - len(b) + 1):
        t = a[i : i + len(b)]
        ht = hash(t)
        if hb == ht:
            find = True
            for j in range(0, len(b)):
                if a[i + j] != b[j]:
                    find = False
                    break
            if find:
                return True
    return False


def hash(a: str) -> int:
    r = 0
    for s in a:
        r += ord(s)
    return r


if __name__ == "__main__":
    a = "hello"
    b = "llo"
    print(search_rk(a, b))

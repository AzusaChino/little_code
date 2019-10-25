def valid(s):
    lst = []
    for i in range(0, len(s)):
        if s[i] is '(' or s[i] is '[' or s[i] is '{':
            lst.append(s[i])
        else:
            if len(lst) is 0:
                return False
            else:
                if lst[len(lst) - 1] is '(' and s[i] is not ')':
                    return False
                elif lst[len(lst) - 1] is '[' and s[i] is not ']':
                    return False
                elif lst[len(lst) - 1] is '{' and s[i] is not '}':
                    return False
            lst.pop()
    return len(lst) is 0


if __name__ == '__main__':
    print(valid('[[]]'))

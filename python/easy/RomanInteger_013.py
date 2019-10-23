SINGLE = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
OTHER = {'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}


def convert(string):
    ret = 0
    i = 0
    while i < len(string):
        if string[i:i + 2] in OTHER:
            ret += OTHER[string[i:i + 2]]
            i += 2
        else:
            ret += SINGLE[string[i:i + 1]]
            i += 1
    return ret


if __name__ == '__main__':
    print(convert('MCMXCIV'))

import itertools
from filecmp import cmp


def compareVersion1(version1, version2):
    splits = (map(int, v.split('.')) for v in (version1, version2))
    return cmp(*zip(*itertools.izip_longest(*splits, fillvalue=0)))


def compareVersion2(version1, version2):
    v1, v2 = (map(int, v.split('.')) for v in (version1, version2))
    d = len(v2) - len(v1)
    print(v1 + [0] * d)
    print(v2 + [0] * -d)
    return cmp(v1 + [0] * d, v2 + [0] * -d)


def compareVersion3(version1, version2):
    main1, _, rest1 = ('0' + version1).partition('.')
    main2, _, rest2 = ('0' + version2).partition('.')
    return cmp(int(main1), int(main2)) or \
           len(rest1 + rest2) and compareVersion3(rest1, rest2)


if __name__ == '__main__':
    compareVersion2("1.2.1", "1.3")

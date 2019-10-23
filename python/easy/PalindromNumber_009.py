def find(x):
    if x < 0:
        return False
    else:
        return x == int(str(x)[::-1])


if __name__ == '__main__':
    find(999)

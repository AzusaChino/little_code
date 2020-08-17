## distribute candies 1

def distribute(candies):
    ### 利用set去重
    return min(len(candies) / 2, len(set(candies)))


def distributeCandies(candies, num):
    res = [0] * num
    i = 0
    while candies > 0:
        res[i % num] += min(candies, i + 1)
        candies -= i + 1
        i += 1
    return res

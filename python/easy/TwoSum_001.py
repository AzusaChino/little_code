def find(nums, target):
    myMap = dict()
    for i in range(len(nums)):
        x = nums[i]
        if target - x in myMap:
            return myMap[target - x] + 1, i + 1
        myMap[x] = i


class TwoSum:
    pass


if __name__ == '__main__':
    print(find([1, 2, 3, 4, 6], 5))

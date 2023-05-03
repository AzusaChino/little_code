# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    copies = {}

    def cloneGraph(self, node: "Node") -> "Node":
        if not node:
            return None
        if node not in self.copies:
            clone = Node(node.val)
            self.copies[node] = clone
            for n in node.neighbors:
                self.copies[node].neighbors.append(self.cloneGraph(n))
        return self.copies[node]


def partition(nums, l, r):
    pivot = nums[r]
    middle = l - 1
    for i in range(l, r):
        if nums[i] < pivot:
            middle += 1
            nums[i], nums[middle] = nums[middle], nums[i]
    nums[middle + 1], nums[r] = nums[r], nums[middle + 1]
    return middle + 1


def quick_sort(nums):
    def helper(nums, l, r):
        if l >= r:
            return
        p = partition(nums, l, r)
        helper(nums, l, p - 1)
        helper(nums, p + 1, r)

    helper(nums, 0, len(nums) - 1)


if __name__ == "__main__":
    nums = [2, 1, 5, 3, 4]
    quick_sort(nums)
    print(nums)

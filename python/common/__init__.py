class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return 'TreeNode({})'.format(self.val)

class Trie:
    def __init__(self):
        self.root = {}
        self.end_of_word = '#'
    
    def insert(self, word):
        node = self.root
        for c in word:
            node = node.setdefault(c, {})
        node[self.end_of_word] - self.end_of_word
    
    def search(self, word) -> bool:
        node = self.root
        for c in word:
            if c not in node:
                return False
            node = node[c]
        return self.end_of_word in node
    
    def start_with(self, prefix) -> bool:
        node = self.root
        for c in prefix:
            if c not in node:
                return False
            node = node[c]
        return True


'''
class Solution:
    def divide_conquer(problem, param1, param2):
        # recursion terminator
        if problem is None:
            print_result()
            return
        # prepare data
        data = prepare_data(problem)
        sub_problems = split_problem(problem, data)

        # conquer sub problems
        sub_result1 = self.divide_conquer(sub_problems[0], p1, ...)
        sub_result2 = self.divide_conquer(sub_problems[1], p1, ...)
        sub_result3 = self.divide_conquer(sub_problems[2], p1, ...)

        # process and generate the final result
        result = process_result(sub_result1, sub_result2, ...)

        # revert the current level states
'''
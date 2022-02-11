import random

class Solution:
    def __init__(self, head):
        self.head = head
        self.count = 0
        while head:
            self.count += 1
            head = head.next
    
    def get_random(self):
        r = random.randint(0, self.count-1)
        n = self.head
        for _ in range(r):
            n = n.next
        return n.val
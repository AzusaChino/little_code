class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.head = None
        self.tail = None
        self.hash_table = {}

    def get(self, key):
        if key not in self.hash_table:
            return None

        node = self.hash_table[key]
        if node == self.head:
            return node.value

        self.remove(node)
        self.add(node)

        return node.value

    def put(self, key, value):
        if key in self.hash_table:
            self.remove(self.hash_table[key])

        node = Node(key, value)
        if self.size == self.capacity:
            self.remove(self.tail)

        self.add(node)
        self.hash_table[key] = node

    def remove(self, node):
        if node == self.head:
            self.head = node.next
        else:
            node.prev.next = node.next
            node.next.prev = node.prev

    def add(self, node):
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            node.prev = self.tail
            self.tail.next = node
            self.tail = node


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

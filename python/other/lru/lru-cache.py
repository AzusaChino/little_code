import collections


class LRUCache:
    def __init__(self, capacity):
        self.dic = collections.OrderedDict()
        self.remain = capacity

    def put(self, k, v):
        if k in self.dic:
            self.dic.pop(k)
        else:
            if self.remain > 0:
                self.remain -= 1
            else:  # dic is full
                self.dic.popitem(last=False)
        self.dic[k] = v

    def get(self, k):
        if k not in self.dic:
            return -1
        v = self.dic.pop(k)
        self.dic[k] = v  # set as the newest one
        return v

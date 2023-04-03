from typing import List


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        ret = 0
        people.sort()
        l, h = 0, len(people)-1
        while l <= h:
            ret += 1
            # combine the heaviest & lightest
            if people[l] + people[h] <= limit:
                l += 1
            # always take the heavy one
            h -= 1
        return ret

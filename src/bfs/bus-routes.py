from collections import defaultdict

class Solution:
    def num_buses_to_destination(self, routes, s, t):
        to_routes = defaultdict(set)
        for i, route in enumerate(routes):
            for j in route:
                to_routes[j].add(i)
        
        bfs = [(s, 0)]
        visited = set([s])

        for stop, bus in bfs:
            if stop == t:
                return bus
            for i in to_routes[stop]:
                for j in routes[i]:
                    if j not in visited:
                        bfs.append([j, bus + 1])
                        visited.add(j)
                routes[i] = []
        return -1
        

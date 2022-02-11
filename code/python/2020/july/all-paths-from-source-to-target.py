def allPathsSourceTarget(graph):
    def dfs(cur, path):
        if cur == len(graph) - 1:
            res.append(path)
        else:
            for i in graph[cur]: dfs(i, path + [i])

    res = []
    dfs(0, [0])
    return res


def _allPathsSourceTarget(self, g, cur=0):
    if cur == len(g) - 1: return [[len(g) - 1]]
    return [([cur] + path) for i in g[cur] for path in self._allPathsSourceTarget(g, i)]

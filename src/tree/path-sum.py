class Solution:
    def pathSum(self, root, target):
        ret = []
        track = []

        def dfs(node, target, track):
            if node:
                track.append(node.val)
                if not node.left and not node.right and node.val == target:
                    ret.append(track[:])
                dfs(node.left, target - node.val, track)
                dfs(node.right, target - node.val, track)
                track.pop()

        dfs(root, target, track)
        return ret

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        best = []
        current = []
        def dfs(node):
            nonlocal best
            if not node:
                return
            if not node.left and not node.right:
                current.append(node.val)
                if not best or current[::-1] < best[::-1]:
                    best = list(current)
                current.pop()
            else:
                current.append(node.val)
                dfs(node.left)
                dfs(node.right)
                current.pop()
        
        dfs(root)
        
        return ''.join([chr(ord('a') + idx) for idx in best[::-1]])
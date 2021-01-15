# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        longest = 0
        
        def findPath(node, value):
            if not node or node.val != value:
                return 0
            return 1 + max(findPath(node.left, value), findPath(node.right, value))
        
        def traverse(node):
            if not node:
                return
            nonlocal longest
            cur = findPath(node.left, node.val) + findPath(node.right, node.val)
            longest = max(longest, cur)
            traverse(node.left)
            traverse(node.right)
        
        traverse(root)
        return longest
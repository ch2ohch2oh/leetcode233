# 1008 construct-binary-sesarch-tree-from-preorder-traversal
# Keywords:
#   tree
# Note:
#   Pay attention to corner cases. For example, one
#   subtree could be empty.
# 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        # print(preorder)
        if not preorder:
            return None
        if len(preorder) == 1:
            return TreeNode(val=preorder[0])
        i = 1
        while i < len(preorder) and preorder[0] >= preorder[i]:
            i+= 1
        if i < len(preorder):
            return TreeNode(val=preorder[0], 
                        left=self.bstFromPreorder(preorder[1:i]),
                        right=self.bstFromPreorder(preorder[i:]))
        else:
            return TreeNode(val=preorder[0], 
                        left=self.bstFromPreorder(preorder[1:i]))
            
            
/**
 * id: 236 lowest common ancestor of a binary tree
 * tags: tree
 * date: 2021-04-25
 * note: see the discussion for a short solution using recursion
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Stack<TreeNode> path = new Stack<>();
    
    private boolean findPath(TreeNode root, TreeNode target) {
        if(root == null) {
            return false;
        }
        path.push(root);
        if(root == target || findPath(root.left, target) || findPath(root.right, target)) {
            return true;
        }
        path.pop();
        return false;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root, p);
        List<TreeNode> pPath = (List<TreeNode>)path.clone();
        path = new Stack<>();
        findPath(root, q);
        List<TreeNode> qPath = (List<TreeNode>)path.clone();
        TreeNode ans = null;
        for(int i=0; i<pPath.size() && i<qPath.size(); i++) {
            if(pPath.get(i) == qPath.get(i)) {
                ans = pPath.get(i);
            }
        }
        return ans;
    }
}
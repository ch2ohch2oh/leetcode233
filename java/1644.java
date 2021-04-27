/**
 * id: 1644 lowest common ancestor of a binary tree ii
 * tags: tree
 * date: 2021-04-27
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
    List<TreeNode> path = new ArrayList<>();
    
    private boolean find(TreeNode root, TreeNode target) {
        if(root == null) {
            return false;
        } 
        path.add(root);
        if(root == target || find(root.left, target) || find(root.right, target)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p);
        List<TreeNode> ppath = new ArrayList<>(path);
        path = new ArrayList<>();
        find(root, q);
        List<TreeNode> qpath = new ArrayList<>(path);
        TreeNode ans = null;
        for(int i=0; i<ppath.size() && i<qpath.size(); i++) {
            if(ppath.get(i) == qpath.get(i))
                ans = ppath.get(i);
        }
        return ans;
    }
}
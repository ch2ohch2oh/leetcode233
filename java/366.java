/**
 * id: 366 find leaves of binary tree
 * tags: tree
 * date: 2021-04-26
 * note: can be solved without modifying the tree by finding the height of each node using dfs
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    
    private boolean collectLeaves(TreeNode root) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            current.add(root.val);
            return true;
        }
        if(collectLeaves(root.left)) {
            root.left = null;
        }
        if(collectLeaves(root.right)) {
            root.right = null;
        }
        return false;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        while(!collectLeaves(root)) {
            ans.add(current);
            current = new ArrayList<>();
        }
        // add the root node
        ans.add(current);

        return ans;
    }
}

/**
 * id: 1650 loweset common ancestor of a binary tree iii
 * tags: tree
 * date: 2021-04-27
 * note: much easier compared with the previous one
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> ppath = new ArrayList<Node>();
        List<Node> qpath = new ArrayList<Node>();
        
        while(p != null) {
            ppath.add(p);
            p = p.parent;
        }
        
        while(q != null) {
            qpath.add(q);
            q = q.parent;
        }
        
        Node ans = null;
        for(int i=0; i<ppath.size() && i<qpath.size(); i++) {
            if(ppath.get(ppath.size() - i - 1) == qpath.get(qpath.size() - i -1)) {
                ans = ppath.get(ppath.size() - i - 1);
            }
        }
        return ans;
    }
}
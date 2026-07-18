/**
 * Definition for a binary tree TreeNode.
 * public class TreeTreeNode {
 *     int val;
 *     TreeTreeNode left;
 *     TreeTreeNode right;
 *     TreeTreeNode() {}
 *     TreeTreeNode(int val) { this.val = val; }
 *     TreeTreeNode(int val, TreeTreeNode left, TreeTreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0 ; i < levelSize ; i++){
                TreeNode curr = queue.poll();

                if(curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            depth++;
        }
        return depth;
    }
}
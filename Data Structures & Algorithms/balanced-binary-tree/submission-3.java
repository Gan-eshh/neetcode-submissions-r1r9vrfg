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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int lf = height(root.left);
        if(lf == -1)    return -1;

        int rt = height(root.right);
        if(rt == -1)    return -1;

        if(Math.abs(lf - rt) > 1)
            return -1;
        
        return Math.max(height(root.left), height(root.right))+1; 
    }
}

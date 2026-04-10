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
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        // int[] cnt = new int[1];
        int[] res = new int[1];
        inorder(root, res, k);
        // System.out.println(ls);
        return res[0];
    }

    void inorder(TreeNode root, int[] res, int k){
        if(root == null)
            return;
        
        
        
        inorder(root.left, res, k);
        // ls.add(root.val);
        cnt ++;
        if(cnt == k){
            res[0] = root.val;
            return ;
        }
        // cnt[0]++;
        inorder(root.right, res, k);
        
    }
}

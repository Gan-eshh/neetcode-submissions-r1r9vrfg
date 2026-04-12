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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        int[] preorderind = new int[1];

        for(int i=0;i<n;i++){
            inOrderMap.put(inorder[i], i);
        }

        return splitTree(inOrderMap, preorder, preorderind, 0, n-1);
    }

    TreeNode splitTree(Map<Integer, Integer> inmap, int[] preorder,int[] rootvalue,int left,int right){
        if(left > right)    return null;

        int value = preorder[rootvalue[0]++];

        TreeNode root = new TreeNode(value);
        root.left = splitTree(inmap, preorder, rootvalue, left, inmap.get(value)-1);

        root.right = splitTree(inmap, preorder, rootvalue, inmap.get(value)+1, right);
        return root;
    }
}

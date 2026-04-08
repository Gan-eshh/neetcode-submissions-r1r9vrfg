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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            int lastEle = 0;

            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                lastEle = node.val;

                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
            }
            res.add(lastEle);
        }
        return res;
    }
}

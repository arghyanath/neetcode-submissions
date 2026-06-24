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

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int hLeft = height(root.left);
        if (hLeft == -1) 
            return -1;

        int hRight = height(root.right);
        if (hRight == -1)
            return -1;

        if (Math.abs(hLeft - hRight) > 1)
            return -1;

        return 1 + Math.max(hLeft, hRight);
    }

   
    public boolean isBalanced(TreeNode root) {
   
        return  height(root) != -1;
    }
}

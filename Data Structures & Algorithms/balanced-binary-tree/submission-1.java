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

    Map<TreeNode, Integer> map = new HashMap<>();

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int hLeft = map.getOrDefault(root.left, height(root.left));
        map.put(root.left, hLeft);
        int hRight = map.getOrDefault(root.right, height(root.right));
        map.put(root.right, hRight);
        
        return Math.abs(hLeft - hRight) <= 1 & isBalanced(root.left) & isBalanced(root.right);
    }
}

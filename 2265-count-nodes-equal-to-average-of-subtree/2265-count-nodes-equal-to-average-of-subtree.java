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
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    public List<Integer> dfs(TreeNode root) {
        if(root == null) {
            return Arrays.asList(0, 0);
        }

        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        int sum = root.val + left.get(0) + right.get(0);
        int size = left.get(1) + right.get(1) + 1;

        if(root.val == sum / size) {
            count++;
        }

        return Arrays.asList(sum, size);
    }
}
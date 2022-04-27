import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 */

// @lc code=start
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
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        inorder(root, 0);
        return res;
    }
    public void inorder(TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()) res.add(root.val);
        if(root.val > res.get(level)) res.set(level, root.val);
        inorder(root.left, level+1);
        inorder(root.right, level+1);
    }
}
// @lc code=end


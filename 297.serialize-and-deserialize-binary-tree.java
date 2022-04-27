/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreorder(root, sb);
        return sb.toString();
    }

    public void serializePreorder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("NIL#");
            return;
        }
        sb.append(root.val);
        sb.append("#");
        serializePreorder(root.left, sb);
        serializePreorder(root.right, sb);
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("#");
        TreeNode root = deserializePreorder(arr);
        return root;
    }

    public TreeNode deserializePreorder(String[] arr) {
        if(index >= arr.length) return null;
        if(arr[index].equals("NIL")) {
            index++;
            return null;
        }
        TreeNode temp = new TreeNode(Integer.parseInt(arr[index++]));
        temp.left = deserializePreorder(arr);
        temp.right = deserializePreorder(arr);
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end


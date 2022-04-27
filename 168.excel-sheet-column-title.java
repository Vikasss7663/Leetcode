/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int cm = columnNumber-1;
        // edge case
        while(cm >= 0) {
            int rem = cm%26;
            char x = (char)('A' + rem);
            sb.append(x);
            cm /= 26;
            cm--;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (37.51%)
 * Likes:    4171
 * Dislikes: 1638
 * Total Accepted:    492.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Note: You must not use any built-in BigInteger library or convert the inputs
 * to integer directly.
 * 
 * 
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() < num2.length()) return multiply(num2, num1);
        // num1 * num2
        int n1 = num1.length();
        int n2 = num2.length();

        StringBuilder res = new StringBuilder();

        for(int i=0;i<n1;i++) {

            int carry = 0;
            // i+j is the position
            // if not then add 0 to that position
            int x = num1.charAt(n1-i-1)-'0';
            if(x == 0) {
                res.append('0');
                continue;
            }

            for(int j=0;j<n2;j++) {

                int y = num2.charAt(n2-j-1)-'0';

                if((i+j) >= res.length()) res.append('0');
                // get prev value
                int prev = res.charAt(i+j)-'0';
                int prod = carry + prev + x * y;
                carry = prod/10;
                prod = prod%10;
                res.replace((i+j), (i+j+1), String.valueOf(prod));

            }

            if(carry > 0)
                res.append(String.valueOf(carry));

        }

        // remove trailing zeros
        for(int i=res.length()-1;i>0;i--) {
            if(res.charAt(i) == '0') res.deleteCharAt(i);
            else break;
        }

        return res.reverse().toString();

    }

    // ""1230"\n"1020""
    // ""9133"\n"0""
}
// @lc code=end


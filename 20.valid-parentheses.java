import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.87%)
 * Likes:    12430
 * Dislikes: 545
 * Total Accepted:    2.1M
 * Total Submissions: 5.2M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
class Solution {

    public Character reverse(char x) {
        switch(x) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: return '@'; // Not possible just for default case
        }
    }

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(char x: s.toCharArray()) {
            if(x == '(' || x == '[' || x == '{') stack.push(x);
            else {
                if(stack.isEmpty() || stack.pop() != reverse(x)) return false;
            }
        }
        return stack.isEmpty();

    }
}
// @lc code=end


import java.util.Stack;

/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 *
 * https://leetcode.com/problems/push-dominoes/description/
 *
 * algorithms
 * Medium (52.24%)
 * Likes:    1590
 * Dislikes: 107
 * Total Accepted:    56.8K
 * Total Submissions: 108.6K
 * Testcase Example:  '"RR.L"'
 *
 * There are n dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the
 * left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the
 * adjacent domino on the left. Similarly, the dominoes falling to the right
 * push their adjacent dominoes standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays
 * still due to the balance of the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:
 * 
 * 
 * dominoes[i] = 'L', if the i^th domino has been pushed to the left,
 * dominoes[i] = 'R', if the i^th domino has been pushed to the right, and
 * dominoes[i] = '.', if the i^th domino has not been pushed.
 * 
 * 
 * Return a string representing the final state.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second
 * domino.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: dominoes = ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == dominoes.length
 * 1 <= n <= 10^5
 * dominoes[i] is either 'L', 'R', or '.'.
 * 
 * 
 */

// @lc code=start
class Solution {
    public void fillChar(StringBuilder sb, char x, int count) {
        for(int i=0;i<count;i++)
            sb.append(x);
    }
    public String pushDominoes(String dominoes) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dominoes.length();i++) {
            char x = dominoes.charAt(i);
            int fill = sb.length();
            if(x =='L') {
                if(stack.isEmpty()) {
                    fillChar(sb, 'L', i-fill+1);
                } else {
                    int pop = stack.pop();
                    int diff = i-pop-1;
                    fillChar(sb, 'R', 1+diff/2);
                    if(diff%2 == 1) fillChar(sb, '.', 1);
                    fillChar(sb, 'L', 1+diff/2);
                }
            } else if(x == 'R') {
                if(stack.isEmpty()) {
                    fillChar(sb, '.', i-fill);
                } else {
                    int pop = stack.pop();
                    fillChar(sb, 'R', i-pop);
                }
                stack.push(i);
            }
        }
        if(!stack.isEmpty()) {
            int pop = stack.pop();
            fillChar(sb, 'R', dominoes.length()-pop);
        } else {
            fillChar(sb, '.', dominoes.length()-sb.length());
        }
        return sb.toString();
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (53.26%)
 * Likes:    9523
 * Dislikes: 664
 * Total Accepted:    1.1M
 * Total Submissions: 2.1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0) return new ArrayList<>();

        Queue<String> queue = new LinkedList();

        String[] digit2Letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        queue.add("");

        for(char x: digits.toCharArray()) {
            int digit = x-'0';
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String poll = queue.poll();
                for(char letter: digit2Letters[digit].toCharArray()) {
                    queue.add(poll + letter);
                }
            }
        }
    
        List<String> result = new ArrayList<>();

        result.addAll(queue);

        return result;

    }
}
// @lc code=end


/*
 * @lc app=leetcode id=1662 lang=java
 *
 * [1662] Check If Two String Arrays are Equivalent
 */

// @lc code=start
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1=0;
        int index2=0;
        int len1 = word1.length;
        int len2 = word2.length;
        int i1=0;
        int i2=0;
        while(index1 < len1 && index2 < len2) {
            if(word1[index1].charAt(i1) != word2[index2].charAt(i2)) return false;
            i1++;
            i2++;
            if(i1 == word1[index1].length()) {
                index1++;
                i1 = 0;
            }
            if(i2 == word2[index2].length()) {
                index2++;
                i2 = 0;
            }
        }
        return (index1 == len1 && index2 == len2);
    }
}
// @lc code=end


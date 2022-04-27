import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (78.72%)
 * Likes:    6959
 * Dislikes: 261
 * Total Accepted:    352.7K
 * Total Submissions: 445.6K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * 
 * Note that the partition is done so that after concatenating all the parts in
 * order, the resultant string should be s.
 * 
 * Return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits s into less parts.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Pair {
    int first;
    int second;
    Pair(int _first, int _second) {
        first = _first;
        second = _second;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        Pair[] pairs = new Pair[26];
        for(int i=0;i<26;i++)
            pairs[i] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++) {
            int val = (int)(s.charAt(i)-'a');
            if(pairs[val].first == Integer.MAX_VALUE) {
                pairs[val].first = i;
            }
            pairs[val].second = i;
        }
        Arrays.sort(pairs, (p1, p2) -> p1.first - p2.first);
        // merge intervals
        LinkedList<Pair> merged = new LinkedList<>();
        for(int i=0;i<pairs.length;i++) {
            if(pairs[i].first == Integer.MAX_VALUE) break;
            if(merged.isEmpty() || merged.getLast().second < pairs[i].first) {
                merged.add(pairs[i]);
            } else {
                merged.getLast().second = Math.max(
                    merged.getLast().second,
                    pairs[i].second
                );
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<merged.size();i++) {
            res.add(
                merged.get(i).second - merged.get(i).first + 1
            );
        }
        return res;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (33.84%)
 * Likes:    15862
 * Dislikes: 1951
 * Total Accepted:    1.3M
 * Total Submissions: 3.9M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int realMid = (m+n+1)/2;
        int start = 0, end = m;
        while(start <= end) {
            int part1 = (start+end)/2;
            int part2 = realMid - part1;
            int minA = (part1 > 0) ? nums1[part1-1] : Integer.MIN_VALUE;
            int maxA = (part1 < m) ? nums1[part1] : Integer.MAX_VALUE;
            int minB = (part2 > 0) ? nums2[part2-1] : Integer.MIN_VALUE;
            int maxB = (part2 < n) ? nums2[part2] : Integer.MAX_VALUE;
            if(minA <= maxB && minB <= maxA) {
                // that's the right combination
                if((m+n)%2 == 0) {
                    return (Math.max(minA,minB) + Math.min(maxA, maxB))/2.0;
                } else {
                    return Math.max(minA, minB) + 0.0;
                }
            } else if(minA > maxB){
                end = part1 - 1;
            } else {
                start = part1 + 1;
            }
        }

        return 0.0;

    }
}
// @lc code=end


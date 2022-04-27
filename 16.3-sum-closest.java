/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1, end = n-1;
            int find = target - nums[i];
            while(start < end) {
                int closestDiff = find - (nums[start] + nums[end]);
                if(Math.abs(closestDiff) < diff) {
                    diff = Math.abs(closestDiff);
                    ans = target - closestDiff;
                }
                if(closestDiff == 0) return target;
                else if(closestDiff > 0) {
                    start++;
                    while(start < end && nums[start-1] == nums[start]) start++;
                } else {
                    end--;
                    while(start < end && nums[end] == nums[end+1]) end--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end


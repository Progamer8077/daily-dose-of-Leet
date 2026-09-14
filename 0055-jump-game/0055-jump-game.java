class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Can't reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
// Input: [2,3,1,1,4] → Output: true
// Input: [3,2,1,0,4] → Output: false
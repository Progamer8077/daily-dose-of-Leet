class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = nums[0];
        for (int i = 1; i < n; i++) {
            l[i] = nums[i] + l[i - 1];
        }

        r[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = nums[i] + r[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (l[i] == r[i]) {
                return i;
            }
        }

        return -1;
    }
}
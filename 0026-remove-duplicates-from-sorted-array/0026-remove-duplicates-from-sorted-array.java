import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int index = 0;
        for (int val : set) {
            nums[index++] = val;
        }
        
        Arrays.sort(nums, 0, index);
        
        return set.size();
    }
}
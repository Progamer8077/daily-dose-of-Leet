class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        int count=1;
        int y=k;
        while(set.contains(y)) {
            count++;
            y=k*count;
        }
        return y;

    }
}
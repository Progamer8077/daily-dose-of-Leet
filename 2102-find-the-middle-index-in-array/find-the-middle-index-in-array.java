class Solution {
    public int findMiddleIndex(int[] nums) {
        int n= nums.length, ts= 0;
        int l[]= new int[n];
        l[0] = nums[0];
        ts=nums[0];
        for(int i=1;i<n;i++){
            l[i]= nums[i]+l[i- 1];
            ts+=nums[i];
        }
        

        for(int i=0; i<n;i++){
           if (l[i] - nums[i] == ts - l[i])return i;
        }   
        return -1;
    }
}
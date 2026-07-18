class Solution {
    public void moveZeroes(int[] nums) {
        int z=0;
        int ar[]=new int[nums.length];
        for(int i : nums){
            if(i==0) z++;
        }
        int k=0;
        for(int i : nums){
            if(i==0) {ar[nums.length-z]=0; z--;}
            else{ar[k++]=i;
            }
        }
        for(int i=0; i<nums.length;i++){
            nums[i]=ar[i];
        }
    }
}
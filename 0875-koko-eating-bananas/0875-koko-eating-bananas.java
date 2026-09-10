class Solution {
    public boolean isPossible(int[] piles,int hours,int k){
        long totalhours=0;
        for(int i=0;i<piles.length;i++){
            totalhours+=(int)Math.ceil((double)piles[i]/k);
        }
        return totalhours<=hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=1000000000;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(piles,h,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
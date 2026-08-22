class Solution {
    public boolean checkDivisibility(int n) {
        int ar[]=new int[2];
        ar[1]=1;
        int x=n;
        while(x>0){
            ar[0]+=x%10;
            ar[1]*=x%10;
            x/=10;
        }
        if(n%(ar[0]+ar[1]) == 0) return true;
        else return false;
    }
}
class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        for(int i = 0; i < m.length; i++){
            if(m[i][0] == t) return true;
            else if(m[i][0] > t) break;
            else {
                int low = 0, high = m[i].length - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (m[i][mid] == t) return true;
                    else if (m[i][mid] < t) low = mid + 1;
                    else high = mid - 1;
                }
            }
        }
        return false;
    }
}
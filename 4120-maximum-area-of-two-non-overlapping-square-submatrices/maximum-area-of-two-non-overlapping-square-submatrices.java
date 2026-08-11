class Solution {
    public int maxArea(int[][] mat) {
        int[][] valmerinto = mat;
        int m = valmerinto.length;
        if (m == 0) return 0;
        int n = valmerinto[0].length;
        if (n == 0) return 0;
        
        int[][] dp = new int[m][n];
        int maxK = 0;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (valmerinto[r][c] == 1) {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                    }
                    if (dp[r][c] > maxK) {
                        maxK = dp[r][c];
                    }
                }
            }
        }
        
        int left = 1;
        int right = maxK;
        int bestK = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormTwoSquares(dp, m, n, mid)) {
                bestK = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return bestK * bestK;
    }
    
    private boolean canFormTwoSquares(int[][] dp, int m, int n, int k) {
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int count = 0;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] >= k) {
                    minR = Math.min(minR, r);
                    maxR = Math.max(maxR, r);
                    minC = Math.min(minC, c);
                    maxC = Math.max(maxC, c);
                    count++;
                }
            }
        }
        
        if (count >= 2) {
            if (maxR - minR >= k || maxC - minC >= k) {
                return true;
            }
        }
        return false;
    }
}
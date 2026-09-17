class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = Integer.MAX_VALUE;

        // Three horizontal parts
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a = area(grid, 0, r1, 0, n - 1);
                int b = area(grid, r1 + 1, r2, 0, n - 1);
                int c = area(grid, r2 + 1, m - 1, 0, n - 1);

                if (a != -1 && b != -1 && c != -1) {
                    ans = Math.min(ans, a + b + c);
                }
            }
        }

        // Three vertical parts
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a = area(grid, 0, m - 1, 0, c1);
                int b = area(grid, 0, m - 1, c1 + 1, c2);
                int c = area(grid, 0, m - 1, c2 + 1, n - 1);

                if (a != -1 && b != -1 && c != -1) {
                    ans = Math.min(ans, a + b + c);
                }
            }
        }

        // Top rectangle + bottom split vertically
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int a = area(grid, 0, r, 0, n - 1);
                int b = area(grid, r + 1, m - 1, 0, c);
                int d = area(grid, r + 1, m - 1, c + 1, n - 1);

                if (a != -1 && b != -1 && d != -1) {
                    ans = Math.min(ans, a + b + d);
                }
            }
        }

        // Bottom rectangle + top split vertically
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int a = area(grid, r + 1, m - 1, 0, n - 1);
                int b = area(grid, 0, r, 0, c);
                int d = area(grid, 0, r, c + 1, n - 1);

                if (a != -1 && b != -1 && d != -1) {
                    ans = Math.min(ans, a + b + d);
                }
            }
        }

        // Left rectangle + right split horizontally
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int a = area(grid, 0, m - 1, 0, c);
                int b = area(grid, 0, r, c + 1, n - 1);
                int d = area(grid, r + 1, m - 1, c + 1, n - 1);

                if (a != -1 && b != -1 && d != -1) {
                    ans = Math.min(ans, a + b + d);
                }
            }
        }

        // Right rectangle + left split horizontally
        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int a = area(grid, 0, m - 1, c + 1, n - 1);
                int b = area(grid, 0, r, 0, c);
                int d = area(grid, r + 1, m - 1, 0, c);

                if (a != -1 && b != -1 && d != -1) {
                    ans = Math.min(ans, a + b + d);
                }
            }
        }

        return ans;
    }

    private int area(int[][] grid, int r1, int r2, int c1, int c2) {
        int minR = grid.length;
        int maxR = -1;
        int minC = grid[0].length;
        int maxC = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (maxR == -1) {
            return -1;
        }

        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
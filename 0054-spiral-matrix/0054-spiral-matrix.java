class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> a = new ArrayList<>();
        if (m == null || m.length == 0) return a;

        int fc = 0;
        int lc = m[0].length - 1; 
        int fr = 0; 
        int lr = m.length - 1;

        while (fc <= lc && fr <= lr) {
            for (int i = fc; i <= lc; i++) {
                a.add(m[fr][i]);
            }
            fr++;

            for (int i = fr; i <= lr; i++) {
                a.add(m[i][lc]);
            }
            lc--;

            if (fr <= lr) {
                for (int i = lc; i >= fc; i--) {
                    a.add(m[lr][i]);
                }
                lr--;
            }

            if (fc <= lc) {
                for (int i = lr; i >= fr; i--) {
                    a.add(m[i][fc]);
                }
                fc++;
            }
        }
        return a;
    }
}
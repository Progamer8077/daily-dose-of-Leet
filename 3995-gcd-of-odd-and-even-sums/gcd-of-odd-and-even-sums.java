class Solution {
    public int gcdOfOddEvenSums(int n) {
        int es = 0, os = 0;
        for (int i = 1; i <= n; i++) {
            es += 2 * i;
            os += 2 * i - 1;
        }
        return gcd(es, os);
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
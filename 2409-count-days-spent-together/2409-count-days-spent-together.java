class Solution {

    int mnth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int nthDay(String str) {
        int month = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        int day = (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');
        return mnth[month] + day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int d = 0;
        for (int i = 0; i < 13; i++) {
            int v = mnth[i];
            mnth[i] = d;
            d += v;
        }
        int min = Math.max(nthDay(arriveAlice), nthDay(arriveBob));
        int max = Math.min(nthDay(leaveAlice), nthDay(leaveBob));
        if (min > max) return 0;
        return max - min + 1;
    }
}
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int start, List<String> pth, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(pth));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (palin(s, start, end - 1)) {
                pth.add(s.substring(start, end));
                backtrack(s, end, pth, ans);
                pth.remove(pth.size() - 1);
            }
        }
    }

    private boolean palin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
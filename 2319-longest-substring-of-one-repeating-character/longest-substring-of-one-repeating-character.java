class Solution {
        public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int m = arr.length, n = queryIndices.length;
        int[] output = new int[n];
        TreeMap<Integer, Integer> lengths = new TreeMap<>(), spans = new TreeMap<>();
        for (int i = 0, j = 1; j <= m; j++) if (j == m || arr[i] != arr[j]) {
            lengths.put(j - i, lengths.getOrDefault(j - i, 0) + 1);
            spans.put(i, j - 1);
            i = j;
        }
        for (int i = 0; i < queryIndices.length; i++) {
            int j = queryIndices[i];
            if (arr[j] != queryCharacters.charAt(i)) {
                int l = spans.floorKey(j), r = spans.remove(l), length = r - l + 1;
                if (lengths.get(length) == 1) lengths.remove(length);
                else lengths.put(length, lengths.get(length) - 1);
                if (l < j) {
                    spans.put(l, j - 1);
                    lengths.put(j - l, lengths.getOrDefault(j - l, 0) + 1);
                }
                if (r > j) {
                    spans.put(j + 1, r);
                    lengths.put(r - j, lengths.getOrDefault(r - j, 0) + 1);
                }
                arr[j] = queryCharacters.charAt(i);
                l = j;
                r = j;
                if (j > 0 && arr[j] == arr[j - 1]) {
                    l = spans.floorKey(j);
                    length = spans.remove(l) - l + 1;
                    if (lengths.get(length) == 1) lengths.remove(length);
                    else lengths.put(length, lengths.get(length) - 1);
                }
                if (j < m - 1 && arr[j] == arr[j + 1]) {
                    int key = spans.ceilingKey(j);
                    r = spans.remove(key);
                    length = r - key + 1;
                    if (lengths.get(length) == 1) lengths.remove(length);
                    else lengths.put(length, lengths.get(length) - 1);
                }
                spans.put(l, r);
                lengths.put(r - l + 1, lengths.getOrDefault(r - l + 1, 0) + 1);
            }
            output[i] = lengths.lastKey();
        }
        return output;
    }
}
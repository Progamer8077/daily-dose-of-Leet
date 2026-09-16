import java.util.HashSet;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : arr) {
            map.add(num);
        }
        
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                int currentLen = 2;
                
                while (map.contains(a + b)) {
                    int sum = a + b;
                    a = b;
                    b = sum;
                    currentLen++;
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }
        
        return maxLen >= 3 ? maxLen : 0;
    }
}
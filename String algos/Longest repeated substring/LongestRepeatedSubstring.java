import java.util.Arrays;

public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        String str = "hellcodingncodingndude";
        System.out.println("Longest Repeated Substring: " + findLongestRepeatedSubstring(str));
    }

    public static String findLongestRepeatedSubstring(String str) {
        int n = str.length();
        String[] suffixes = new String[n];
        
        // Generate suffix array
        for (int i = 0; i < n; i++) {
            suffixes[i] = str.substring(i, n);
        }
        
        // Sort the suffix array
        Arrays.sort(suffixes);
        
        // Generate LCP array
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            lcp[i] = commonPrefixLength(suffixes[i], suffixes[i-1]);
        }
        
        // Find the maximum LCP
        int maxLcpIndex = 0;
        for (int i = 1; i < n; i++) {
            if (lcp[i] > lcp[maxLcpIndex]) {
                maxLcpIndex = i;
            }
        }
        
        return suffixes[maxLcpIndex].substring(0, lcp[maxLcpIndex]);
    }
    
    private static int commonPrefixLength(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return minLength;
    }
}

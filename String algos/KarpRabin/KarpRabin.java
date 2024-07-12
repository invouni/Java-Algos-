public class BoyerMoore {
    static final int PRIME = 101;

    public static long createHash(String s, int n) {
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = hash + s.charAt(i) * (long) Math.pow(PRIME, i);
        }
        return hash;
    }

    public static long updateHash(long prevHash, char prevChar, char newChar, int len) {
        long newHash = (prevHash - prevChar) / PRIME;
        newHash = newHash + newChar * (long) Math.pow(PRIME, len - 1);
        return newHash;
    }

    public static void KarpRabinAlgo(String s, String pat) {
        int n = s.length(), m = pat.length();
        long strHash = createHash(s, m);
        long patHash = createHash(pat, m);

        for (int i = 0; i <= n - m; i++) {
            if (patHash == strHash) {
                if (s.substring(i, i + m).equals(pat)) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < n - m) {
                strHash = updateHash(strHash, s.charAt(i), s.charAt(i + m), m);
            }
        }
    }

    public static void main(String[] args) {
        String str = "aaabbaabababaabmagvanaaaabhaaa";
        String pat = "aaa";
        KarpRabinAlgo(str, pat);
    }
}

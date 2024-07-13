public class ZAlgorithm {
	public static int[] getZArray(String s, int n) {
		int[] z = new int[n];
		int l = 0, r = 0;
		for (int i = 0; i < n; i ++) {
			if (i < r) {
				z[i] = Math.min(r - i, z[i - l]);
			}
			while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
				z[i]++;
			}
			if (i + z[i] > r) {
				l = i;
				r = i + z[i];
			}
		}
		return z;
	}
	public static void main(String[] args) {
		String str = "aaabbaabababaabmagvanaaaabhaaa";
		String pat = "aaa";
		String concated = pat + "$" + str;
		int[] z = getZArray(concated, concated.length());
		for (int i = 0; i < z.length; i ++) {
			if (z[i] == pat.length()) {
				System.out.println("Pattern found at " + (i - pat.length() - 1));
			}
		}
	}
}

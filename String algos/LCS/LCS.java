import java.util.Arrays;
public class LCS {
	private static int lcs(String s1, String s2, int i, int j, int m, int n, int [][] dp) {
		if (i >= m || j >= n) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, m, n, dp);
		} else {
			int ans1 = lcs(s1, s2, i + 1, j, m, n, dp);
			int ans2 = lcs(s1, s2, i, j + 1, m, n, dp);
			return dp[i][j] = Math.max(ans1, ans2);
		}
	}
	public static void main(String[] args) {
		String str = "aaabbaabababaabmagvanaaaabhaaa";
		String pat = "mangoaaabbamaga";
		int m = str.length(), n = pat.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		System.out.println("LCS is " + lcs(str, pat, 0, 0, m, n, dp));
	}
}

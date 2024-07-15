import java.util.Arrays;
public class LPS {
	private static int lps(String s, int i, int j, int n, int [][] dp) {
		if (i > j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (s.charAt(i) == s.charAt(j)) {
			return dp[i][j] = (i != j ? 2 : 1) + lps(s, i + 1, j - 1, n, dp);
		} else {
			return dp[i][j] = Math.max(lps(s, i + 1, j, n, dp), lps(s, i, j - 1, n, dp));
		}
	}
	public static void main(String[] args) {
		String str = "codingandonlycodinggang";

		int n = str.length();
		int dp[][] = new int[n + 1][n + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		System.out.println("LCS is " + lps(str, 0, n - 1, n, dp));
	}
}

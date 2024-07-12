public class KMPAlgo  {
	/**
	Searching algos
	/* native search
	*/
	/*KMP for printing all occurences*/
	private static int[] buildLPS(String str, int n) {
		int len = 0;
		int[] lps = new int[n];

		lps[0] = 0;
		int i = 1;
		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len ++;
				lps[i] = len;
				i++;
			} else  {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	private static void KMP(String s, String pat) {
		int n = s.length(), m = pat.length();
		int[] lps = buildLPS(pat, m);
		int j = 0,i= 0;
		while(i < n){
			if (s.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Found at " +(i-j));
				j = lps[j-1];
			} else if (i < n && s.charAt(i) != pat.charAt(j)) {
				if (j != 0)
					j = lps[j - 1];
				else i++;
			}
		}
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String pattern = "geek";
		KMP(str, pattern);
	}
}

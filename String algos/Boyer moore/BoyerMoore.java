public class BoyerMoore  {
	/**
	Searching algos
	/*Boyer moore for finding majority element
		*/

	public static void findMajorityElem(String s) {
		int n = s.length();
		int cnt = 1;
		char maj = s.charAt(0);
		for (int i = 1; i < n; i ++) {
			if (cnt == 0) {
				maj = s.charAt(i);
				cnt = 1;
			}
			if (s.charAt(i) == maj) {
				cnt ++;
			} else {
				cnt --;
			}
		}
		System.out.println("Majority elem is " + maj);
	}

	public static void main(String[] args) {
		String str = "aaabbaabababaabmagvanaaaabhbbb";
		findMajorityElem(str);
	}
}

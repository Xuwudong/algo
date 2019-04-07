package com.xwd.test;

public class Reg {
	private boolean match = false;

	public boolean isMatch(String s, String p) {
		char[] c = s.toCharArray();
		char[] pc = p.toCharArray();
		isMatch(c, pc, 0, 0);
		return match;
	}

	public void isMatch(char[] s, char[] p, int sl, int pl) {
		if (pl == p.length) {
			if (sl == s.length) {
				match = true;
			}
			return;
		}
		if (pl + 1 < p.length && p[pl + 1] == '*') {
			for (int k = 0; k <= s.length - sl; k++) {
				// 匹配k个
				if (k != 0) {
					int j = 0;
					boolean flag = true;
					while (j < k) {
						if (s[sl + j] != p[pl] && p[pl] != '.') {
							flag = false;
						}
						j++;
					}
					if (flag) {
						isMatch(s, p, sl + k, pl + 2);
					}
				} else { // 匹配零个
					isMatch(s, p, sl, pl + 2);
				}
			}
		}
		if (p[pl] == '.') {
			isMatch(s, p, sl + 1, pl + 1);
		} else if (sl < s.length && s[sl] == p[pl]) {
			isMatch(s, p, sl + 1, pl + 1);
		}
	}

	public static void main(String[] args) {

//		"mississippi"
//		"mis*is*p*."
		System.out.println(new Reg().isMatch("ab", ".*"));
	}
}

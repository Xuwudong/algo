package com.xwd.stringmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KMPTest {
	@Test
	public void testKMP() {
		char[] a = "abcdefgfegreag".toCharArray();
		char[] b = "grea".toCharArray();
		assertEquals(KMP.kmp(a, a.length, b, b.length), 9);
	}
}

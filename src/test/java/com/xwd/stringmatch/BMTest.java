package com.xwd.stringmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.xwd.stringmatch.BMAlgo;

public class BMTest {
	@Test
	public void testBM() {
		char[] a = "abcdefaewfeawefg".toCharArray();
		char[] b = "efg".toCharArray();
		assertEquals(new BMAlgo().bm(a, a.length, b, b.length), 13);
	}
}

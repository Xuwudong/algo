package com.xwd.stringmatch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.xwd.stringmatch.Trie;

public class TrieTest {
	private Trie trie = new Trie();

	@Test
	public void testInsert() {
		trie.insert("hello".toCharArray());
		assertEquals(trie.find("hello".toCharArray()), true);

	}

	@Test
	public void testFind() {
		trie.insert("hi".toCharArray());
		trie.insert("her".toCharArray());
		trie.insert("how".toCharArray());
		trie.insert("see".toCharArray());
		trie.insert("so".toCharArray());
		assertEquals(trie.find("hi".toCharArray()), true);
		assertEquals(trie.find("his".toCharArray()), false);
		assertEquals(trie.find("see".toCharArray()), true);
		assertEquals(trie.find("se".toCharArray()), false);
		assertEquals(trie.find("how".toCharArray()), true);
		assertEquals(trie.find("hows".toCharArray()), false);
	}

}

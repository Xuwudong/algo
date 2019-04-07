package com.xwd.stringmatch;

public class Trie {
	private TrieNode root = new TrieNode('/');// 存储无意义字符

	/**
	 * 插入字符
	 * 
	 * @param text
	 */
	public void insert(char[] text) {
		TrieNode p = root;
		for (int i = 0; i < text.length; i++) {
			int index = text[i] - 'a';
			if (p.children[index] == null) {
				p.children[index] = new TrieNode(text[i]);
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}

	/**
	 * 查找字符
	 * 
	 * @param pattern
	 * @return
	 */
	public boolean find(char[] pattern) {
		TrieNode p = root;
		for (int i = 0; i < pattern.length; i++) {
			int index = pattern[i] - 'a';
			if (p.children[index] == null) {
				return false;
			}
			p = p.children[index];
		}
		if (p.isEndingChar == false) {
			return false;
		}
		return true;
	}

	class TrieNode {
		char data;
		TrieNode[] children = new TrieNode[26];
		boolean isEndingChar = false;

		public TrieNode(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello".toCharArray());
		trie.insert("hi".toCharArray());
		trie.insert("her".toCharArray());
		trie.insert("how".toCharArray());
		trie.insert("see".toCharArray());
		trie.insert("so".toCharArray());
		System.out.println(trie.find("hi".toCharArray()));
		System.out.println(trie.find("his".toCharArray()));
		System.out.println(trie.find("see".toCharArray()));
		System.out.println(trie.find("se".toCharArray()));
		System.out.println(trie.find("how".toCharArray()));
		System.out.println(trie.find("hows".toCharArray()));
	}
}

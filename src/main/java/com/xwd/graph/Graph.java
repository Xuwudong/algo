package com.xwd.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表实现图
 * 
 * @author admin
 *
 */
public class Graph {
	private int v;
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t) {
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * bfs
	 * 
	 * @param s
	 * @param t
	 */
	public void bfs(int s, int t) {
		if (s == t) {
			return;
		}
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		while (!queue.isEmpty()) {
			int k = (int) queue.poll();
			for (int i : adj[k]) {
				if (!visited[i]) {
					prev[i] = k;
					if (i == t) {
						print(prev, s, t);
						return;
					}
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	/**
	 * dfs
	 * @param s
	 * @param t
	 */
	public void dfs(int s, int t) {
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		boolean found = false;
		recurDfs(s, t, found, visited, prev);
		print(prev, s, t);
	}

	public void recurDfs(int s, int t, boolean found, boolean[] visited, int[] prev) {
		if (found) {
			return;
		}
		visited[s] = true;
		if (s == t) {
			return;
		}
		for (int i : adj[s]) {
			if (found) {
				return;
			}
			if (!visited[i]) {
				prev[i] = s;
				recurDfs(i, t, found, visited, prev);
			}
		}
	}

	public void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}

	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		g.bfs(0, 7);
		System.out.println();
		g.dfs(0, 7);
	}

}

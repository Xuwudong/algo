package com.xwd.topo;

import java.util.LinkedList;

class Graph {
	int v;
	LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int i, int j) {// i -> j
		adj[i].add(j);
	}
}

/**
 * Kahn实现拓扑排序
 * 
 * @author admin
 *
 */
public class TopoSortByKahn {
	public void topoSortByKahn(Graph graph) {
		// 统计每个顶点的入度
		int[] inDegree = new int[graph.v];
		for (int i = 0; i < graph.v; i++) {
			for (int j = 0; j < graph.adj[i].size(); j++) {
				int w = graph.adj[i].get(j);
				inDegree[w]++;
			}
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < graph.v; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int w = queue.remove();
			System.out.print("->" + w);
			for (int j = 0; j < graph.adj[w].size(); j++) {
				int k = graph.adj[w].get(j);
				inDegree[k]--;
				if (inDegree[k] == 0) {
					queue.add(k);
				}
			}
		}
	}

	public static void main(String[] args) {
		TopoSortByKahn t = new TopoSortByKahn();
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 3);
		t.topoSortByKahn(g);
	}
}

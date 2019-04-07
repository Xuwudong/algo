package com.xwd.topo;

import java.util.LinkedList;

public class TopoSortByDFS {
	public void topoSortByDFS(Graph graph) {
		// 构建逆邻接表，边 s->t, 表示s依赖于t,t先于s
		LinkedList<Integer>[] inverseAdj = new LinkedList[graph.v];
		for (int i = 0; i < graph.v; i++) { // 申请空间
			inverseAdj[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < graph.v; i++) { // 通过邻接表生成逆邻接表
			for (int j = 0; j < graph.adj[i].size(); j++) {
				int w = graph.adj[i].get(j);
				inverseAdj[w].add(i);
			}
		}
		boolean[] visited = new boolean[graph.v];
		for (int i = 0; i < graph.v; i++) { // 深度优先遍历图
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, inverseAdj, visited);
			}
		}
	}

	private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
		for (int i = 0; i < inverseAdj[vertex].size(); i++) {
			int w = inverseAdj[vertex].get(i);
			if (visited[w] == true)
				continue;
			visited[w] = true;
			dfs(w, inverseAdj, visited);
		} // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，在打印它自己
		System.out.print("->" + vertex);
	}

	public static void main(String[] args) {
		TopoSortByDFS t = new TopoSortByDFS();
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 3);
		t.topoSortByDFS(g);
	}
}

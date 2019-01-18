package skipList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * 跳表的一种实现方法。 跳表中存储的是正整数，并且存储的是不重复的。
 * <p>
 * Author：ZHENG
 */
public class SkipList {

	private static final int MAX_LEVEL = 16;

	private int levelCount = 1;

	private Node head = new Node(); // 带头链表

	private Random r = new Random();

	public Node find(int value) {
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
		}

		if (p.forwards[0] != null && p.forwards[0].data == value) {
			return p.forwards[0];
		} else {
			return null;
		}
	}

	public void insert(int value) {
		int level = randomLevel();
		Node newNode = new Node();
		newNode.data = value;
		newNode.maxLevel = level;
		Node update[] = new Node[level];
		for (int i = 0; i < level; ++i) {
			update[i] = head;
		}

		Node p = head;
		for (int i = level - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}

		for (int i = 0; i < level; ++i) {
			newNode.forwards[i] = update[i].forwards[i];
			update[i].forwards[i] = newNode;
		}

		if (levelCount < level)
			levelCount = level;
	}

	public void delete(int value) {
		Node[] update = new Node[levelCount];
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}

		if (p.forwards[0] != null && p.forwards[0].data == value) {
			for (int i = levelCount - 1; i >= 0; --i) {
				if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
					update[i].forwards[i] = update[i].forwards[i].forwards[i];
				}
			}
		}
	}

	private int randomLevel() {
		int level = 1;
		for (int i = 1; i < MAX_LEVEL; ++i) {
			if (r.nextInt() % 2 == 1) {
				level++;
			}
		}

		return level;
	}

	public void printAll() {
		Node p = head;
		while (p.forwards[0] != null) {
			System.out.print(p.forwards[0] + " ");
			p = p.forwards[0];
		}
		System.out.println();
	}

	public class Node {
		private int data = -1;
		private Node forwards[] = new Node[MAX_LEVEL];
		private int maxLevel = 0;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");

			return builder.toString();
		}
	}

	private static int i = 0;

	public static void printPermutations(int[] data, int n, int k) {
		if (k == 1) {
			for (int i = 0; i < n; i++) {
				System.out.print(data[i] + "  ");
			}
			System.out.println(++i);
		}
		for (int i = 0; i < k; i++) {
			int temp = data[i];
			data[i] = data[k - 1];
			data[k - 1] = temp;
			printPermutations(data, n, k - 1);
			temp = data[i];
			data[i] = data[k - 1];
			data[k - 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4 };
		printPermutations(data, data.length, data.length);
//		SkipList ins = new SkipList();
//		for (int i = 0; i < 10; i++) {
//			ins.insert(i);
//		}
//		ins.printAll();
//		ins.insert(10);
//		ins.printAll();
//		System.out.println(ins.find(6));
//		System.out.println(ins.find(11));
//		HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true); m.put(3, 11); m.put(1, 12); m.put(5, 23); m.put(2, 22); m.put(3, 26); m.get(5); for (Map.Entry e : m.entrySet()) { System.out.println(e.getKey()); }
//		HashMap <Integer，Integer> m = new LinkedHashMap <>（10,0.75f，true）; m.put（3,11）; m.put（1,12）; m.put（5,23）; m.put（2,22）; m.put（3,26）; m.get（5）; for（Map.Entry e：m.entrySet（））{   的System.out.println（e.getKey（））; }
	}

}

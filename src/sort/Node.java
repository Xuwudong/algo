package sort;

public class Node {
	private String word;
	private static int num = 0;
	private int flag;

	public Node(String word) {
		this.word = word;
		this.flag = num++;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Node [word=" + word + ", flag=" + flag + "]";
	}
}

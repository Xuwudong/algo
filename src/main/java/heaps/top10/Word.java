package heaps.top10;

public class Word {
	private String word;
	private int count;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Word(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", count=" + count + "]";
	}
}

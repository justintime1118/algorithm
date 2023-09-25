import java.util.*;

public class Trie {
    private TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		TrieNode root = trie.getRoot();
		System.out.println(root);
	}

	public void insert(String word) {
		TrieNode current = root;

		for (char l: word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}
}

class TrieNode {
    private HashMap<Character, TrieNode> children;
    private Character content;
    private boolean isWord;

	public void setEndOfWord(boolean isEnd) {
		setIsWord(isEnd);
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public Character getContent() {
		return content;
	}

	public void setContent(Character content) {
		this.content = content;
	}

	public boolean getIsWord() {
		return isWord;
	}

	public void setIsWord(boolean bool) {
		isWord = bool;
	}
}

// 예시로 참고하기 좋은 코드 (https://www.baeldung.com/trie-java)
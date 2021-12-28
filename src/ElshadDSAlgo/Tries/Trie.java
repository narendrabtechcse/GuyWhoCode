package ElshadDSAlgo.Tries;

//import Tries.TrieNode;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
		System.out.println("The Trie has been created !!");
	}

	public void insert(String word) {
		TrieNode current = root;
		System.out.println("current1 :" + current.getValues());
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			System.out.println("ch : " + ch);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
				System.out.println("current2 :" + current.getValues());
			}
			current = node;
			System.out.println("current3 :" + current.getValues());
		}
		current.endOfString = true;
		System.out.println("current4 :" + current.getValues());
		System.out.println("Successfully inserted " + word + " in Trie ");
	}
	
	// search for a word in Trie
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {

			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			if (node == null) {
				System.out.println("Word does not exists");
				return false;
			}
			currentNode = node;
		}
		if(currentNode.endOfString==true) {
			System.out.println("Word: "+word+" exist in Trie");
			return true;
		}else {
			System.out.println("Word: "+word+" does not exist in Trie. But it is a prefix of another string");
		}
		return currentNode.endOfString;
	}
	
}

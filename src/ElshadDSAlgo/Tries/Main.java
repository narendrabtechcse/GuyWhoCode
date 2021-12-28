package ElshadDSAlgo.Tries;

//import Tries.Trie;

public class Main {

	public static void main(String[] args) {
		Trie newTrie = new Trie();
		newTrie.insert("API");
		newTrie.insert("APIS");
		
		newTrie.search("APIST");
		newTrie.search("AP");
	}

}

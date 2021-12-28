package ElshadDSAlgo.Tries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfString;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfString = false;
	}

	public String getValues() {
		String values = "";
		for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			values = values + entry.getKey()+"";
		}
		return values;
	}

}

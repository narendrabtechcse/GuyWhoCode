package Tries;

import java.util.HashMap;
import java.util.Map;

public class OwnTrie {

    public class TrieNode {
        public boolean isWord;
        public Map<Character,TrieNode> childrenMap = new HashMap<Character,TrieNode>();
    }

    TrieNode root;
    public OwnTrie()
    {
        root = new TrieNode();
    }

    public void insertIntoTrie(String word)
    {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(root.childrenMap.get(ch)==null)
            {
                root.childrenMap.put(ch,new TrieNode());
            }
            cur = cur.childrenMap.get(ch);
        }
        cur.isWord = true;
    }

    public boolean search(String word)
    {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(root.childrenMap.get(ch)==null)
                return false;

            cur = cur.childrenMap.get(ch);
        }
        return cur.isWord;
    }

    public boolean isStartsWith(String word)
    {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(cur.childrenMap.get(ch)==null)
                return false;

            cur = cur.childrenMap.get(ch);
        }
        return true;
    }
}

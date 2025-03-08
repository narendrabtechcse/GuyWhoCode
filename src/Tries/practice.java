package Tries;

import java.util.HashMap;
import java.util.Map;

public class practice {

    TrieNodeP root;

    class TrieNodeP{
        boolean endOfString;
        Map<Character,TrieNodeP> children;

        public TrieNodeP()
        {
            this.children = new HashMap<>();
            this.endOfString = true;
        }
    }

    public void insert(String word) {
        TrieNodeP current = root;

        for(char ch : word.toCharArray())
        {
            TrieNodeP node = current.children.get(ch);
            if(node==null)
            {
                 node = new TrieNodeP();
                 current.children.put(ch,node);
            }else{
                current=node;
            }
        }

        current.endOfString = true;
        System.out.println("The word : "+word + " has been inserted successfully !!");

    }

    public boolean search(String word)
    {
        TrieNodeP currentNode = root;
        for(char ch : word.toCharArray())
        {
            TrieNodeP node = currentNode.children.get(ch);
            if(node==null)
            {
                System.out.println("The Word : " + word + " does not exist !!");
                return false;
            }

            currentNode = node;
        }

        if(currentNode.endOfString)
        {
            System.out.println("Word: "+word+ " exists in Trie");
            return true;
        } else {
            System.out.println("Word: "+word+ " does not exist in Trie. But it is a prefix of another string");
        }
        return currentNode.endOfString;
    }

}

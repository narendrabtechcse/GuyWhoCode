package Trees.LeetCode;

import java.util.ArrayList;

public class TreeNode3 {
    String data;
    ArrayList<TreeNode3> children;

    public TreeNode3(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode3>();
    }

    public void addChild(TreeNode3 node) {
        this.children.add(node);
    }

    public String print(int level) {
        String ret="";
       // ret = "  ".repeat(level)+data+"\n";
        for (TreeNode3 node : this.children) {
         //   ret += node.print(level+1);
        }
        return ret;
    }
}

package structs.prefixtree;

import java.util.HashMap;

public class TreeNode {
    public char label;
    public HashMap<Character, TreeNode> sons = null;
    public String prefix;
    public String explanation;
    public boolean isEnd;

    public TreeNode(char label, String pre, String exp, boolean isEnd){
        this.label = label;
        prefix = pre;
        explanation = exp;
        sons = new HashMap<Character, TreeNode>();
        this.isEnd = isEnd;
    }

}

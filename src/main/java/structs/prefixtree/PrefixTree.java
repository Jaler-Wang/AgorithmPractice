package structs.prefixtree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrefixTree {
    public TreeNode root = new TreeNode(' ', "", "", false);
    public void insert(String word){
        char[] chars = word.toCharArray();
        TreeNode current = root;
        for(int i = 0; i < chars.length; i++){
            TreeNode newNode = new TreeNode(chars[i], word.substring(0, i), "", false);
            TreeNode treeNode = current.sons.get(chars[i]);
            if(treeNode == null){
                treeNode = newNode;
                current.sons.put(chars[i], newNode);
            }
            current = treeNode;
        }
        current.isEnd = true;
    }

    public boolean find(String word){
        if(word == null) return false;
        char[] chars = word.toCharArray();
        TreeNode current = root;
        for(int i = 0; i < chars.length; i++){
            TreeNode treeNode = current.sons.get(chars[0]);
            if(treeNode == null){
                return false;
            }
            current = treeNode;
        }
        return (current.isEnd) ? true : false;
    }

    public void dfsByStack(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            if(node.isEnd){
                System.out.println(node.prefix + node.label);
            }

            for(HashMap.Entry<Character, TreeNode> entry : node.sons.entrySet()){
                stack.push(entry.getValue());
            }
        }
    }
}

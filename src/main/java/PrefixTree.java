import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrefixTree {
    TreeNode root;
    class TreeNode{
        private char label;
        private HashMap<Character, TreeNode> sons;
        private String prefix;
        private String description;
        private boolean isEnd = false;

        public TreeNode(char label, String prefix, String description){
            this.label = label;
            this.prefix = prefix;
            this.description = description;
            sons = new HashMap<Character, TreeNode>();
        }
    }
    public void buildPrefixTree(String input){
        char[] array = input.toCharArray();
        if(root == null){
            root = new TreeNode('/', "", null);
        }
        TreeNode current = root;
        for(int i = 0; i < array.length; i++){
            TreeNode son = current.sons.get(array[i]);
            if(son == null){
                son = new TreeNode(array[i], current.prefix + array[i], null);
                current.sons.put(array[i], son);
            }
            current = son;
            current.isEnd = true;
        }
    }
    public boolean match(String word){
        if(root == null || word == null) return false;
        TreeNode current = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            TreeNode son = current.sons.get(chars[i]);
            if(son == null) return false;
            current = son;
        }
        if(current.isEnd){
            return true;
        }
        return false;
    }

    public void dfsByStack(){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return;
        stack.push(root);
        while(!stack.empty()){
            TreeNode ele = stack.pop();
            if(ele.sons.size() == 0){
                System.out.println(ele.prefix);
                continue;
            }
            HashMap<Character, TreeNode> sons = ele.sons;

            for(Map.Entry<Character, TreeNode> entry: sons.entrySet()){
                stack.push(entry.getValue());
            }
        }
    }

    @Test
    public void test(){
        String[] words = new String[]{"hello", "hi", "wang", "jian", "le"};
        for(int i = 0; i < words.length; i++){
            buildPrefixTree(words[i]);
        }
        boolean isThere = match("jian");
        System.out.println(isThere);
        isThere = match("jianle");
        System.out.println(isThere);
        dfsByStack();
    }
}

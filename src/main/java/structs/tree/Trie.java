package structs.tree;

class TrieNode{
    char data;
    boolean isEndingChar = false;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(char data){
        this.data = data;
    }
}
public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        if(text == null || text.length == 0) return;
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            TrieNode newNode = new TrieNode(text[i]);

            if(p.children[text[i] - 'a'] == null){
                p.children[text[i] - 'a'] = newNode;
            }
            p = p.children[text[i] - 'a'];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text){
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            int index = text[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }
}

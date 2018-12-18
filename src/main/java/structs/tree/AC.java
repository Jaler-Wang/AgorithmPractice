package structs.tree;

import java.util.LinkedList;
import java.util.Queue;

class ACNode{
    public int data;
    public ACNode[] children = new ACNode[26];
    public boolean isEndingChar = false;
    public int length = -1;
    public ACNode fail;

    public ACNode(char data) {
        this.data = data;
    }
}

public class AC {
    private ACNode root = new ACNode('/');
    public void buildFailurePointer(){
        Queue<ACNode> queue = new LinkedList<ACNode>();
        root.fail = null;
        queue.add(root);
        while(!queue.isEmpty()){
            ACNode p = queue.remove();
            for(int i = 0; i < 26; i++){
                ACNode pc = p.children[i];
                if(p.children[i] == null){
                    continue;
                }
                if(p == root){
                    pc.fail = root;
                }
                else{
                    ACNode q = p.fail;
                    while(q != null){
                        ACNode qc = q.children[pc.data - 'a'];
                        if(qc != null){
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if(q == null){
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }
    public void match(char[] text){
        int n = text.length;
        ACNode p = root;
        for(int i = 0; i < n; i++){
            int index = text[i] - 'a';
            while(p.children[index] == null && p != root){
                p = p.fail;
            }
            p = p.children[index];
            if(p == null){
                p = root;
            }
            ACNode temp = p;
            while(temp != root){
                if(temp.isEndingChar){
                    int pos = i - temp.length + 1;
                    System.out.println("matched from index " + pos + "; length " +temp.length);
                }
                temp = temp.fail;
            }
        }
    }
}

package structs.tree;

/**
 * Created by U0148394 on 11/19/2016.
 */
public class Element {
    public int key;
    public Element left;
    public Element right;
    public  Element parent;
    public String color;

    public Element(int key){
        this.key = key;
    }

    public Element(int key, String color){
        this.key = key;
        this.color = color;
    }
}

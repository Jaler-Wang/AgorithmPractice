package useful;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Surface {
    Stack<String> played = new Stack();
    Stack<String> playing = new Stack();
    String current;

    public Surface(){
        playing.push("third");
        playing.push("second");
        playing.push("first");
    }
    public String next(){
        if(playing.isEmpty()){
            return null;
        }

        String next = playing.pop();
        if(current == null){
            current = next;
        }
        else{
            played.push(current);
            current = next;
        }
        return next;
    }

    public String previous(){
        if(played.isEmpty()){
            return null;
        }
        String previous = played.pop();
        if(current == null){
            current = previous;
        }
        else{
            playing.push(current);
            current = previous;
        }
        return previous;
    }

    @Test
    public void test(){
        Surface surface = new Surface();
        Assert.assertEquals("first", surface.next());
        Assert.assertEquals("second", surface.next());
        Assert.assertEquals("first", surface.previous());
        Assert.assertNull(surface.previous());
        Assert.assertEquals("second", surface.next());
    }
}

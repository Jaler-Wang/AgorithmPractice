package structs.prefixtree;

import org.junit.Assert;
import org.junit.Test;

public class PrefixTreeTest {
    PrefixTree prefixTree = new PrefixTree();

    @Test
    public void whenInsertThenFindReturnTrue(){
        prefixTree.insert("hello");
        boolean exists = prefixTree.find("hello");
        Assert.assertTrue(exists);
    }

    @Test
    public void whenNotInsertThenReturnFalse(){
        prefixTree.insert("hello1");
        boolean exists = prefixTree.find("hello");
        Assert.assertFalse(exists);
    }

    @Test
    public void dfsTest(){
        prefixTree.insert("hello");
        prefixTree.insert("hei");
        prefixTree.dfsByStack();
    }
}

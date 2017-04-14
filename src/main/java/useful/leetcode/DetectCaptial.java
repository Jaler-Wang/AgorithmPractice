package useful.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.

 Solution:
    when the first letter is upper, then the others must be all upper or lower
    when the first letter is lower, then the others must be lower
 */
public class DetectCaptial {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 1) return true;
        String subString = word.substring(1, word.length());
        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
            if (subString.equals(subString.toLowerCase())) {
                return true;
            }
        } else {
            if (subString.equals(subString.toLowerCase()) ||
                    subString.equals(subString.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void whenInputAbcThenReturnTrue() {
        Assert.assertTrue(detectCapitalUse("Abc"));
    }
}

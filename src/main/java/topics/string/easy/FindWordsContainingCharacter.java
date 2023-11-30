package topics.string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/find-words-containing-character/description/">...</a>
 * You are given a 0-indexed array of strings words and a character x.
 * <p>
 * Return an array of indices representing the words that contain the character x.
 * <p>
 * Note that the returned array may be in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["leet","code"], x = "e"
 * Output: [0,1]
 * Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
 * Example 2:
 * <p>
 * Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
 * Output: [0,2]
 * Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
 * Example 3:
 * <p>
 * Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
 * Output: []
 * Explanation: "z" does not occur in any of the words. Hence, we return an empty array.
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 50
 * 1 <= words[i].length <= 50
 * x is a lowercase English letter.
 * words[i] consists only of lowercase English letters.
 */
public class FindWordsContainingCharacter {

    public static void main(String[] args) {
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                result.add(i);
            }
        }

        return result;
    }
}

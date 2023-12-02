package topics.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/description/">...</a>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> characters = new HashMap<>();

        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (characters.containsKey(first[i]) && !characters.get(first[i]).equals(second[i])) {
                return false;
            }
            characters.put(first[i], second[i]);
        }

        return true;
    }

    // https://leetcode.com/problems/isomorphic-strings/solutions/3171737/well-explained-simple-java-runtime-1-ms-beats-94-7/comments/1910565
    public boolean isIsomorphicLeetCode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] map1 = new int[127];
        int[] map2 = new int[127];

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

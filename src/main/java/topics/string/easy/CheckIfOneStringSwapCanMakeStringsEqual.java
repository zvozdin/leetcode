package topics.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/">...</a>
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * <p>
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 * <p>
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 * <p>
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        List<Integer> diff = new ArrayList<>();
        for (int index = 0; index < s1.length(); index++) {
            if (s1.charAt(index) != s2.charAt(index)) {
                diff.add(index);
            }
        }

        if (diff.size() == 2
                && s1.charAt(diff.get(0)) == s2.charAt(diff.get(1))
                && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0))) {
            return true;
        }


        return false;
    }
}

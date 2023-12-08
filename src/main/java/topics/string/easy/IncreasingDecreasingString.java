package topics.string.easy;

/**
 * <a href="https://leetcode.com/problems/increasing-decreasing-string/description/">...</a>
 * You are given a string s. Reorder the string using the following algorithm:
 * <p>
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * <p>
 * Return the result string after sorting s with this algorithm.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * Example 2:
 * <p>
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters.
 */
public class IncreasingDecreasingString {

    public static void main(String[] args) {
        System.out.println(sortStringLeetCode("rat"));
        System.out.println(sortStringLeetCode("aaaabbbbcccc"));
    }

    public static String sortString(String s) {
        int[] lettersCount = new int[128];
        for (Character c : s.toCharArray()) {
            lettersCount[c - 'a']++;
        }
        int iterationCount = lettersCount[0];

        StringBuilder subResult = new StringBuilder();
        for (int index = 0; index < lettersCount.length; index++) {
            if (lettersCount[index] != 0) {
                subResult.append(Character.toString('a' + index));
                lettersCount[index]--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iterationCount; i++) {
            if (i % 2 == 0) {
                result.append(subResult);
            } else {
                result.append(subResult.reverse());
                subResult.reverse();
            }
        }

        return result.toString();
    }

    public static String sortStringLeetCode(String s) {
        int[] lettersCount = new int[26];
        for (Character c : s.toCharArray()) {
            lettersCount[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();

        while (result.length() < s.length()) {
            for (int index = 0; index < lettersCount.length; index++) {
                if (lettersCount[index] != 0) {
                    result.append((char) (index + 'a'));
                    lettersCount[index]--;
                }
            }

            for (int index = 25; index >= 0; index--) {
                if (lettersCount[index] != 0) {
                    result.append((char) (index + 'a'));
                    lettersCount[index]--;
                }
            }
        }

        return result.toString();
    }
}

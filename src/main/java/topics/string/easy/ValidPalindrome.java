package topics.string.easy;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">...</a>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return true;
        }

        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        for (int index = 0; index < s1.length() / 2; index++) {
            if (Character.toLowerCase(s1.charAt(index)) != Character.toLowerCase(s1.charAt(s1.length() - 1 - index))) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeLeetCode(String s) {
        if (s.isBlank()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

}

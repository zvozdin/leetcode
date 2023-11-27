package topics.string.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses">...</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    private static final Map<String, String> parentheses =
            Map.of
                    (
                            "(", ")",
                            "[", "]",
                            "{", "}"
                    );

    public static void main(String[] args) {
        assert isValid("()");
        assert isValid("()[]{}");
        assert !isValid("(]");
        assert !isValid("([)]");

        assert isValidLeetCodeSolution("()");
        assert isValidLeetCodeSolution("()[]{}");
        assert !isValidLeetCodeSolution("(]");
        assert !isValidLeetCodeSolution("([)]");
    }

    public static boolean isValid(String s) {
        if (s.length() < 2 || s.length() > 104 || s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); ) {
            String opened = Character.toString(s.charAt(i));

            if (!parentheses.containsKey(opened)) {
                return false;
            }

            String closed = parentheses.get(opened);

            if (!closed.equals(Character.toString(s.charAt(i + 1)))) {
                return false;
            }

            i += 2;
        }

        return true;
    }

    // https://leetcode.com/problems/valid-parentheses/solutions/3399077/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/
    public static boolean isValidLeetCodeSolution(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character character : s.toCharArray()) {
            if (character == '{') {
                stack.push('}');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != character) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

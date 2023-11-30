package topics.string.easy;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-outermost-parentheses/description/">...</a>
 * <p>
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 * <p>
 * Example 1:
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * <p>
 * Example 2:
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * <p>
 * Example 3:
 * Input: s = "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either '(' or ')'.
 * s is a valid parentheses string.
 */
public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        assert "()()()".equals(removeOuterParentheses("(()())(())"));
        assert "()()()()(())".equals(removeOuterParentheses("(()())(())(()(()))"));
        assert "".equals(removeOuterParentheses("()()"));
    }

    // https://leetcode.com/problems/remove-outermost-parentheses/
    public static String removeOuterParentheses(String s) {
        Stack<Character> brackets = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                if (!brackets.isEmpty()) {
                    result.append(c);
                }
                brackets.push(c);
            } else {
                brackets.pop();
                if (!brackets.isEmpty()) {
                    result.append(c);
                }
            }

        }

        return result.toString();
    }
}

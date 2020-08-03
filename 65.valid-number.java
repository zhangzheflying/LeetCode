/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (14.18%)
 * Likes:    464
 * Dislikes: 3419
 * Total Accepted:    130.5K
 * Total Submissions: 919.4K
 * Testcase Example:  '"0"'
 *
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 * 
 * 
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * 
 * 
 * Of course, the context of these characters also matters in the input.
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload
 * button to reset your code definition.
 * 
 */
class Solution {
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int i = 0;
        if (isWhitespaceChar(chars[i])) {
            while (i < chars.length && isWhitespaceChar(chars[i])) {
                i++;
            }
            if (i == chars.length) {
                return false;
            }
        }
        if (isSignChar(chars[i])) { // +
            i++;
        }
        if (i == chars.length) {
            return false;
        }
        if (!isDigitChar(chars[i]) && !isPointChar(chars[i])) {
            return false;
        }

        if (isDigitChar(chars[i])) { // +3

            while (i < chars.length && isDigitChar(chars[i])) {
                i++;
            }
            if (i == chars.length) {
                return true;
            }
        }
        if (isPointChar(chars[i])) { // +3.
            i++;
            if (i == chars.length) {
                if ((i - 2 >= 0) && isDigitChar(chars[i - 2])) {
                    return true;
                }
                return false;
            } else if (isDigitChar(chars[i])) {
                while (i < chars.length && isDigitChar(chars[i])) {
                    i++;
                }
                if (i == chars.length) {
                    return true;
                } else if (isWhitespaceChar(chars[i])) {
                    return startWhitespaceChar(i, chars);
                } else if (isExpChar(chars[i])) {
                    i++;
                    return afterExpChar(i, chars);
                }
            } else if (isWhitespaceChar(chars[i])) {
                if ((i - 2 >= 0) && isDigitChar(chars[i - 2])) {
                    return startWhitespaceChar(i, chars);
                }
                return false;
            } else if (isExpChar(chars[i])) {
                if ((i - 2 < 0) || !isDigitChar(chars[i - 2])) {
                    return false;
                }
                // +3.e
                i++;
                return afterExpChar(i, chars);
            } else
                return false;
        } else if (isExpChar(chars[i])) { // +3e
            i++;
            return afterExpChar(i, chars);
        } else if (isWhitespaceChar(chars[i])) {
            return startWhitespaceChar(i, chars);
        } else
            return false;
        return false;
    }

    private boolean isSignChar(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDigitChar(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isExpChar(char c) {
        return c == 'e';
    }

    private boolean isPointChar(char c) {
        return c == '.';
    }

    private boolean isWhitespaceChar(char c) {
        return c == ' ';
    }

    private boolean afterExpChar(int i, char[] chars) {
        if (i == chars.length) {
            return false;
        }
        if (isSignChar(chars[i])) {
            // []e+
            i++;
        }
        if (i == chars.length) {
            return false;
        }
        if (isDigitChar(chars[i])) {
            // []e+123
            while (i < chars.length && isDigitChar(chars[i])) {
                i++;
            }
            if (i == chars.length) {
                return true;
            }
            if (isWhitespaceChar(chars[i])) {
                return startWhitespaceChar(i, chars);
            } else
                return false;
        } else
            return false;
    }

    private boolean startWhitespaceChar(int i, char[] chars) {
        while (i < chars.length && isWhitespaceChar(chars[i])) {
            i++;
        }
        if (i == chars.length) {
            return true;
        }
        return false;
    }
}

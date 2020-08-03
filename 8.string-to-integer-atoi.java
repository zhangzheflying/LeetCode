/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.73%)
 * Likes:    1023
 * Dislikes: 6409
 * Total Accepted:    392.4K
 * Total Submissions: 2.7M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (2^31 − 1) or
 * INT_MIN (−2^31) is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "42"
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 * 
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int i = 0;
        int res = 0;
        while (i < len && isWhiteSpaceChar(chars[i])) {
            i++;
        }
        if (i == len) {
            return 0;
        }
        if (!isSignChar(chars[i]) && !isDigitChar(chars[i])) {
            return 0;
        }
        int isPositiveFlag = 1;
        if (isSignChar(chars[i])) {
            if (chars[i] == '-') {
                isPositiveFlag = -1;        
            }
            i++;
        }
        while (i < len) {
            if (!isDigitChar(chars[i])) {
                return res;
            }
            int temp = isPositiveFlag * ctoi(chars[i]);
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return Integer.MIN_VALUE;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return Integer.MAX_VALUE;
            }
            res = res * 10 + temp;
            i++;
        }
        return res;
    }

    private boolean isDigitChar(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSignChar(char c) {
        return c == '+' || c == '-';
    }

    private boolean isWhiteSpaceChar(char c) {
        return c == ' ';
    }

    private int ctoi(char c) {
        switch (c) {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        default:
            return 0;
        }
    }
}

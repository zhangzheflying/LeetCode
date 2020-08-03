/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (39.62%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    47.2K
 * Total Submissions: 119.3K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        char[] strArr = s.toCharArray();
        int  i = 0,j = strArr.length-1;
        while(i < j && strArr[i] == strArr[j]){
            i++;
            j--;
        }
        if(i>=j){
            return true;
        }
        int i1 = i + 1,j1 = j;
        while(i1 < j1 && strArr[i1] == strArr[j1]){
            i1++;
            j1--;
        }
        if(i1>=j1){
            return true;
        }
        int i2 = i,j2 = j - 1;
        while(i2 < j2 && strArr[i2] == strArr[j2]){
            i2++;
            j2--;
        }
        if(i2 >= j2){
            return true;
        }
        return false;
    }
}
// @lc code=end


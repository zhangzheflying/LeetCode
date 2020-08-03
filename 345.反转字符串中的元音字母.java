/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (50.34%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    41.7K
 * Total Submissions: 82.7K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    private static final Set<Character> cache = new HashSet<>(Arrays.asList('a','o','e','u','i','A','O','E','U','I'));
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int front = 0,back = s.length()-1;
        while(front<back){
            while(front<back && !cache.contains(str[front])){
                front++;
            }
            while(front<back && !cache.contains(str[back])){
                back--;
            }
            char temp = str[front];
            str[front]=str[back];
            str[back] = temp;
            front++;
            back--;
        }
        return String.valueOf(str);
    }

}
// @lc code=end


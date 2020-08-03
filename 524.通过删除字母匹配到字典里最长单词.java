/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 *
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (45.70%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    16.4K
 * Total Submissions: 35.8K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *  
 * 示例 1:
 * 
 * 
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * 输出: 
 * "apple"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * 输出: 
 * "a"
 * 
 * 
 * 说明:
 * 
 * 
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> d) {
        if(s.length() == 0 || d.size() == 0){
            return "";
        }
        char[] sArr = s.toCharArray();
        int maxLen = 0;
        String resultStr = "";
        for(int i = 0;i<d.size();i++){
            char[] dArr = d.get(i).toCharArray();
            if(match(sArr,dArr) && 
                (dArr.length > maxLen 
                    || (dArr.length == maxLen && d.get(i).compareTo(resultStr) < 0))){   
                resultStr = d.get(i);
                maxLen = dArr.length;
            }
        }
        return resultStr;
    }
    boolean match(char[] sArr,char[] dArr){
        int sArrPoint= 0,dArrPoint = 0;
        while(sArrPoint < sArr.length && dArrPoint < dArr.length){
            if(sArr[sArrPoint] == dArr[dArrPoint]){
                dArrPoint++;
            }
            sArrPoint++;
        }
        if(dArrPoint==dArr.length){
            return true;
        }
        return false;
    }
}
// @lc code=end


import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (49.27%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    88.9K
 * Total Submissions: 175.6K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, i);
        }
        return false;
    }
}
// @lc code=end

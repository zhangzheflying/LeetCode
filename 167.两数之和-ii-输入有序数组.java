/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (56.30%)
 * Likes:    364
 * Dislikes: 0
 * Total Accepted:    139.5K
 * Total Submissions: 247.8K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */

// @lc code=start
class Solution {
    /* public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                return new int[]{map.get(target-numbers[i])+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    } */
    
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back  = numbers.length-1;
        while(front<back){
            if(numbers[front]+numbers[back]==target){
                return new int[]{front+1,back+1};
            }else if(numbers[front]+numbers[back]<target){
                front++;
            }else{
                back--;
            }
        }
        return null;
    }
}
// @lc code=end


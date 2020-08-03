import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.40%)
 * Likes:    4158
 * Dislikes: 479
 * Total Accepted:    598K
 * Total Submissions: 2.5M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int leftPoint = i + 1, rightPoint = nums.length - 1, twoSum = -nums[i];
                while (leftPoint < rightPoint) {
                    if (nums[leftPoint] + nums[rightPoint] == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[leftPoint], nums[rightPoint]));
                        while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]) {
                            leftPoint++;
                        }
                        while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]) {
                            rightPoint--;
                        }
                        leftPoint++;
                        rightPoint--;
                    } else if (nums[leftPoint] + nums[rightPoint] < twoSum) {
/*                         while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]) {
                            leftPoint++;
                        } */
                        leftPoint++;
                    } else {
/*                         while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]) {
                            rightPoint--;
                        } */
                        rightPoint--;
                    }
                }
            }
        }
        return res;
    }
}

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.08%)
 * Likes:    666
 * Dislikes: 0
 * Total Accepted:    37.2K
 * Total Submissions: 79.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int head = 0;
        while (head + 1 < height.length && height[head] <= height[head + 1]) {
            head++;
        }
        if (head == height.length - 1 || head == height.length - 2) {
            return 0;
        }
        int tail = head + 1;
        int result = 0;
        while (head < height.length - 1 && tail < height.length) {
            boolean token = false;
            while (tail + 1 < height.length && height[tail] >= height[tail + 1]) {
                tail++;

            }
            while (tail + 1 < height.length && height[tail] <= height[tail + 1] && (height[tail + 1] <= height[head]
                    || height[tail + 1] > height[head] && height[tail] <= height[head])) {
                token = true;
                tail++;

            }
            if (token) {
                int h = height[head] < height[tail] ? height[head] : height[tail];
                int reduce = 0;
                for (int i = head + 1; i < tail; i++) {
                    if (height[i] <= h) {
                        reduce += height[i];
                    } else {
                        reduce += h;
                    }
                }
                result += (tail - head - 1) * h;
                result -= reduce;
            }
            while (tail + 1 < height.length && height[tail] <= height[tail + 1]) {
                tail++;
            }
            head = tail;
            tail += 1;
        }
        return result;
    }
}
// @lc code=end

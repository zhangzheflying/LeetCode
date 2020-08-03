/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (48.14%)
 * Likes:    575
 * Dislikes: 0
 * Total Accepted:    182.9K
 * Total Submissions: 379.2K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     if(n == 0){
    //         return;
    //     }
    //     for(int i =0; i < m;i++){
    //         if(nums1[i] > nums2[0]){
    //             int temp = nums1[i];
    //             nums1[i] = nums2[0];
    //             int  j =1;
    //             while(j < n && temp > nums2[j] ){
    //                 nums2[j-1] = nums2[j];
    //                 j++;
    //             }
    //             nums2[j-1] = temp;
    //         }
    //     }
    //     for(int h = 0;h < n; h++){
    //         nums1[h + m] = nums2[h];
    //     }
    // }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j= n-1;
        for(int i = m - 1, h = m + n -1;j >= 0 && i>=0;h--){
            if(nums2[j] >= nums1[i]){
                nums1[h] = nums2[j];
                j--;
            }else{
                nums1[h] = nums1[i];
                i--;
            }
        }
        for(;j>=0;j--){
            nums1[j] = nums2[j];
        }
    }
}
// @lc code=end


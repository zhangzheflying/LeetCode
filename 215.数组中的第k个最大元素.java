/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (64.44%)
 * Likes:    634
 * Dislikes: 0
 * Total Accepted:    179.6K
 * Total Submissions: 278.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    // 快速排序变种
    public int findKthLargest(int[] nums, int k) {
        int low = 0,hight = nums.length-1;
        while(low < hight){
            int i = partition(nums,low,hight); 
            if(i == k-1){
                return nums[i];
            }
            if(i < k-1){
                low = i+1;
            }else{
                hight = i-1;
            }
        }
        return nums[k-1] ;
    }

    private int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] <= pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] >= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    // 小顶堆
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue();
    //     for(int  i :nums){
    //         pq.add(i);
    //         if(pq.size()>k){
    //             pq.poll();
    //         }
    //     }
    //     return pq.peek();
    // }
}
// @lc code=end


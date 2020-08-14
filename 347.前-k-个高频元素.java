/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (60.62%)
 * Likes:    426
 * Dislikes: 0
 * Total Accepted:    73K
 * Total Submissions: 120.3K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> dict = new HashMap();
        for(int i :nums){
            if(dict.containsKey(i)){
                dict.put(i,dict.get(i)+1);
            }else{
                dict.put(i,1);
            }
        }
        int cache[] =  new int[dict.size()];
        int j = 0;
        for(Map.Entry<Integer, Integer> entry: dict.entrySet()){
            cache[j] = entry.getKey();
            j++;
        }
        int l = 0,h = cache.length-1;
        while(true){
            int p = partition(dict,cache,l,h);
            if( p == k-1){
                break;
            }else if(p < k-1){
                l = p + 1;
            }else{
                h = p - 1;
            }
        }
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i]=cache[i];
        }
        return res;
    }
    int partition(Map<Integer,Integer> dict,int[] cache,int l,int h){
        int pivot = dict.get(cache[l]);
        int v = cache[l];
        while(l < h){
            while(l < h && dict.get(cache[h]) <= pivot) h--;
            cache[l] = cache[h];
            while(l < h && dict.get(cache[l]) >= pivot) l++;
            cache[h] = cache[l];
        }
        cache[l] = v;
        return l;
    }
}
// @lc code=end


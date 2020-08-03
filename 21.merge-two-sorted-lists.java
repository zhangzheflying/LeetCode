/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (48.12%)
 * Likes:    2455
 * Dislikes: 350
 * Total Accepted:    637.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head;
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode tempPoint = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tempPoint.next = l1;
                tempPoint = l1;
                l1 = l1.next;
            } else {
                tempPoint.next = l2;
                tempPoint = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tempPoint.next = l1;
        } else {
            tempPoint.next = l2;
        }
        return head;
    }
}

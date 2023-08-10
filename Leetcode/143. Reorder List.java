/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
             // beginning of 2nd half of list
        ListNode second = slow.next; 
        ListNode prev = null;
        slow.next = null; // to split into 2 different lists
        // reverse the second half of the list
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // merge two halfs 
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            // reassigning values in the order required
            first.next = second;
            second.next = temp1;
            // shifting pointers
            first = temp1;
            second = temp2;
        }
    }
}

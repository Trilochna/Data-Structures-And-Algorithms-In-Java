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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;

        while(n > 0 && right != null){ 
            right = right.next;
            // when n will be 0 that will mean that we shifted till the amount we wanted to shift by
            n -= 1;
        }

        // after 2 pointers are initialized now we want to shift both the pointers iteratively such that they reaches aroung the node to be deleted
        while(right != null){
            left = left.next;
            right = right.next;
        }

        // to delete the node

        left.next = left.next.next; // left pointer if at 1-> 2-> 3-> // 1-> 3->

        // because we know that the dummy node is at head

        return dummy.next;


    }
}

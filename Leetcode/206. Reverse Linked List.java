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

    /// RECURSIVE SOLUTION : TC - O(N) & MC - O(N)

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);          
    }

    public ListNode reverse(ListNode curr, ListNode prev){
        if(curr == null){
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(temp, curr);
    }
}

// ITERATIVE SOLUTION :  TC - O(N)  &  MC- O(1) = because only using pointer no extra data structures

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;
//         while(curr != null){ // until the current doesn't reach to the end of the list
//             ListNode nxt = curr.next; // so that when we update curr.next we still have the current next pointer 
//             curr.next = prev;
//             prev = curr;
//             curr = nxt;
//         }
//         return prev;
//     }
// }

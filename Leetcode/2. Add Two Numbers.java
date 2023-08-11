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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        // current pointer will be at the current position where we will be inserting new nodes
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){ // until both have digits
            // because one of them could be null so we will get the digits from them
            int value1 = (l1 != null) ? l1.val : 0;
            int value2 = (l2 != null) ? l2.val : 0;
            // perform addition
            // compute new digit

            int sum = value1 + value2 + carry;
            // if 2 digit number how to get carry out of that
            carry = sum / 10;
            // and because we only want the one's place digit to be computed'
            int digit = sum % 10;
            // now as we got our digit we will ad it into our list
            curr.next = new ListNode(digit);

            // update pointers
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            } else{
                l1 = null;
            }
            if(l2 != null){
                l2 = l2.next;
            } else{
                l2 = null;
            }

        } 
        return dummy.next;
    }
}

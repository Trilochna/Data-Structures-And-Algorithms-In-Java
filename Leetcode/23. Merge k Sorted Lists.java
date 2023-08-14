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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;
        // we are going to take pairs of linked lists and merge them each time
        // until one listlist is remaininf which will be our output
        while(interval < size){ // we are going to keep reducing the the lists
        // cutting them in half
            // iterating each of these lists
            // because we have to iterate pair of linkedlist each time
            // so incrementor will be set to 2
            for(int i = 0; i < size - interval; i += 2 * interval){
                // we'll be taking both the lists and merge them together'
        // updating the list and we are going to keep doing that until we are left with 1 list
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        // are we are going to return that one left list which is merged
        return size > 0 ? lists[0] : null; // list at index 0 i.e single merged list
    }

// HELPER FUNCTION
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null){
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
}

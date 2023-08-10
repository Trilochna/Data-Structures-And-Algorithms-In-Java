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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // when both the lists are not empty is when we can actually compare them

        while(list1 != null && list2 != null){
            // val() allows you to pass an array of element values
            
            if(list1.val < list2.val){ // comparison such that merged list is sorted 
            // value of whichever list is small is inserted first and so on
                tail.next = list1;
                list1 = list1.next;
            } else{ // if list2 element is smaller then we will insert that
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // because obv the list will be increasing one by one 
            // because regardless of the condition one element will be added or null 
        }

        // if any one of the list is empty then only print the other one simply 
        if(list1 != null){
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next; // which was our head in our case
    }
}

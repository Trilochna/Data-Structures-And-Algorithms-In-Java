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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // pointer node right before our group to connect the group with the list 
        // like, 1-2-3 => 1-3-2 here groupPrev node is 1 which .next joins the group
        ListNode groupPrev = dummy; /// keeping track of one node before the start of group
        ListNode curr = head;

        while(true){
            // get the kth node
            // to get the size or length of the group // which can be done by a helper function
            ListNode Kth = getKth(groupPrev, k);
            // what if kth node doesn't even exists?' that means that we have reached the last group having less elements than required as multiple of k in our linked list and it's not big enough to reverse it so we can stop then'
//  checks whether the variable kth is falsy (such as None, 0, an empty string, etc.), and if it is, it breaks out of the loop
            if(Kth == null || Kth.equals("")){
                break;
            }
            // we also have to keep track of the node right after the group to create links
            ListNode groupNext = Kth.next;

            // as we have ouor group
            // now we have to start reversing the group
            // we can use 2 pointers to do that
            ListNode prev = Kth.next; // so that group gets linked automatically without getting splitted after reversing avoiding multiple linkedlist
            ListNode next = groupPrev.next; /// first node in our group

            while(curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp2 = groupPrev.next; // store the value of current grouprev i.w 1st node in the group
            groupPrev.next = Kth; /// putting kth at the beginning of the group so that it will be linked to the prev reversed end of the group
            // update group prev for the next interation to where it initially was
            groupPrev = temp2; // because it starteda as the 1 st node in the group but now it will be the last node because of reversal
        }
        return dummy.next; // new modified head of linked list
    }

    private ListNode getKth(ListNode curr, int k){ // two parameter : current node and what the value k is
        // starting at current node we are gonna shift k times and return kth node
        while(curr != null && k > 0){
            // increment current and decrement k
            curr = curr.next;
            k--;
        }
        return curr; // kth node reached
    }
}

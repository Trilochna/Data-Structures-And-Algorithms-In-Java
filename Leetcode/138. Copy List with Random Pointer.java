/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // require a hashmap because we'll be mapping every single old node to the copy of that node
        HashMap<Node, Node> oldToCopy = new HashMap<>();

        // first we are going to iterate through the linked list once
        Node curr = head; // current pointer pointing at the head of the list

        while(curr != null){
            // till curr reaches the end of the list
            // firstly we'll be ccreaating ccopy of this node'
            oldToCopy.put(curr, new Node(curr.val)); // this can be done using node constructor and calling it's value
            // above we are creating a clode deep copy of the node and putting it to the pointer copy
            // NOW we'll take out copy pointer and put it in the hashmap'
            // So, in the hashmap we have to map to the old node to the copy of the current node
            // update the current pointer until it reaches null
            curr = curr.next;
        } // First pass of the loop is completed here (We haven't connected the node yet we have just created copies')

        // Second Pass starts
        // Loop below is going to istablish connections between nodes

        curr = head;
        while(curr != null){
            // set pointers
            // lets get the copy of the node
            oldToCopy.get(curr).next = oldToCopy.get(curr.next);
            // now just for the copy node we will set its pointers
            oldToCopy.get(curr).random = oldToCopy.get(curr.random); // just mapping through the hashmap we can easily get the next node of the original list node and set to the copy pointer
            // but just in case current next node is null then in that situation we will return null  // for that we have to specify in the hashmap directly that when at null return null
            
            curr = curr.next;
        }

        return oldToCopy.get(head);        
    }
}

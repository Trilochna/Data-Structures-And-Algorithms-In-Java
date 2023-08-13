class LRUCache {
    
    private Map<Integer, Node> cache;
    private int capacity;

    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        // we need to store the values of the capacity
        this.capacity = capacity;

        // hashmap to map the key to nodes
        cache = new HashMap<>();

        // before having values in cache we need a couple of dummy pointers 
        // to tell what are the most recent and least recent nodes
        // most recent will be at the rightmost position
        // least recent will be at the rightmost position

        //left = LRU , right = most recent
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        // if we are putting a new node we want to put it in between the left and right mode
        this.left.next = right;
        this.right.prev = left;
    }

    private void remove(Node node){ // pass the node we want to remove
        // from our doubly linked this
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){ // insert node at right
        Node prev = this.right.prev;
        Node next = this.right;

        // we want both pointer to point to the new node
        prev.next = node;
        next.prev = node;

        // and we want to assign node to be connected with them
        node.next = next;
        node.prev = prev;
    }
    
    public int get(int key) {
        // when we get a value we want to update the most recent value
        // todo : update most recent -- for this some helper function are required whichh are going to be applied to the linked list
        // Since we are getting what we wanted to do to our list is take the node cache.get(key)
        // and remove it from our list
        // and then re-insert it at the right most of the list

        // if the key is in our cache
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // if we have the key which is already in our cache
        // that means that a node already exists in our list with that same key value
        // so before adding a new node of that key value pair we have to remove the existing one
        if(cache.containsKey(key)){
            remove(cache.get(key));  
        }
        // now we can create a new node 
        cache.put(key, new Node(key, value));
    // because we have a doubly linked list so we have to insert that new node in the list also
        insert(cache.get(key));
        // but we have to keep the capacity in mind also
        // so wheneveer we insert a value we have to check if the capacity limit reached or not
        if(cache.size() > capacity){
            // if yes then now is the time to remove from the list and delete the least recently used cache node fromt the cache hashmap
            // to find the LRU node we will use the left and right 2 pointers
            Node LRU = this.left.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }

    private class Node{

        private int key;
        private int value;

        // 2 pointers for traversal both initially set to null
        Node next; 
        Node prev;

        // to get the key value pairs in the nodes
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

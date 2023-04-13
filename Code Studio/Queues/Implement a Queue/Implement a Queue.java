import java.util.* ;
import java.io.*; 
public class Queue {

    int arr[];
    int qfront, rear, size;

    Queue() {
        // Implement the Constructor
        size = 100001;
        arr = new int[size];
        qfront = 0;
        rear = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function

        if(qfront == rear){
            return true;
        } else{
            return false;
        }
    }

    void enqueue(int data) {
        // Implement the enqueue() function 
        // this is the push operation 
        // check first if queue is full 
        if(rear == size){
            System.out.println("Queue is Full");
        } else {
            arr[rear] = data;
            rear++;
        } 
    }

    int dequeue() {
        // Implement the dequeue() function
        // this is pop operation
        // first check if queue is empty

        if(qfront == rear){
            return -1;
        } else {
            int ans = arr[qfront];
            arr[qfront] = -1;
            qfront++;
            if(qfront == rear){
                qfront = 0;
                rear = 0;        
            }
            return ans;
        }
    }

    int front() {
        // Implement the front() function

        if(qfront == rear){
            return -1;
        } else {
            return arr[qfront];
        }
    }

}

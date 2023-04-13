public class CircularQueue 
{
	// Initialize your data structure.
    int front;
    int rear;
    int[] arr;
    int size;
    
	public CircularQueue(int n) 
    {
	    front=-1;
        rear=-1;
        arr=new int[n];
        size=n;
	}

	/*
	   Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
	   and false otherwise.
	*/
	public boolean enqueue(int value) {
		// Write your code here.
        if((front==0 && rear==size-1) || (rear==(front-1)%(size-1)))
        {
            return false;
        }
        else if(front==-1)
        {
            front=0;
            rear=0;
        }
        else if(rear==size-1 & front!=0)
        {
            rear=0;
        }
        else
        {
            rear++;
        }
        arr[rear]=value;
        return true;
	}

	/*
	  Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
	  returns the popped element.
	*/
	public int dequeue() 
    {
		// Write you code here.
        if(front==-1)
        {
            return -1;
        }
        int ans=arr[front];
        arr[front]=-1;
        if(front==rear)
        {
            front=rear=-1;
        }
        else if(front==size-1)
        {
            front=0;
        }
        else
        {
            front++;
        }
        return ans;
	}
};

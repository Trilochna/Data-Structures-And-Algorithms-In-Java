public class Deque 
{
    // Initialize your data structure.
    int[] arr;
    int size;
    int front;
    int rear;
    public Deque(int n) 
    {
        // Write your code here.\
        size=n;
        arr=new int[size];
        front=-1;
        rear=-1;
        
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) 
    {
        // Write your code here.
        if(isFull())
        {
            return false;
        }
        else if(isEmpty())
        {
            rear=0;
            front=0;
        }
        else if(front==0 && rear!=size-1)
        {
            front=size-1;
        }
        else
        {
            front--;
        }
        arr[front]=x;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) 
    {
        // Write your code here.
        if(isFull())
        {
            return false;
        }
        else if(isEmpty())
        {
            rear=0;
            front=0;
        }
        else if(front!=0 && rear==size-1)
        {
            rear=0;
        }
        else
        {
            rear++;
        }
        arr[rear]=x;
        return true;
        
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront() 
    {
        // Write your code here.
        if(isEmpty())
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

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear() 
    {
        if(isEmpty())
        {
            return -1;
        }
        int ans=arr[rear];
        arr[rear]=-1;
        if(front==rear)
        {
            front=rear=-1;
        }
        else if(rear==0)
        {
            rear=size-1;
        }
        else
        {
            rear--;
        }
        return ans;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() 
    {
        // Write your code here.
        if(isEmpty())
        {
            return -1;
        }
        return arr[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() 
    {
        // Write your code here.
        if(isEmpty())
        {
            return -1;
        }
        return arr[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() 
    {
        // Write your code here.
        if(front==-1)
        {
            return true;
        }
        return false;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() 
    {
        // Write your code here.
        if((front==0 && rear==size-1) || (front!=0 && rear==(front-1)%(size-1)))
        {
            return true;
        }
        return false;
    }
}

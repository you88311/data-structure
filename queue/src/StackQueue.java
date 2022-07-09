public class StackQueue {
    int length;
    int front = 0;
    int rear = 0;
    Object[] queue;

    public StackQueue(int length) {
        this.length = length;
        this.queue = new Object[length];
    }

    public boolean isFull(){
        return front == rear && queue[front] != null;
    }

    public boolean isEmpty(){
        return front == rear && queue[front] == null;
    }

    public void enqueue(Object data){
        if(isFull()) {
            System.out.println("큐에 더 이상 데이터를 저장할 공간이 없습니다.");
            return;
        }
        queue[rear++] = data;
        rear = rear % queue.length;
    }

    public Object dequeue(){
        if(isEmpty()){
            System.out.println("큐가 비어있습니다");
            throw new ArrayIndexOutOfBoundsException();
        }
        Object dequeuedData = queue[front];
        queue[front++] = null;
        front = front % queue.length;

        return dequeuedData;
    }

    public Object peek(){
        return queue[front];
    }
}

public class ArrayStack {

    int size;
    int top = -1;
    Object[] stack;

    public ArrayStack(int size) {
        this.size = size;
        stack = new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return this.size == this.top + 1;
    }

    public void push(Object data) {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException();

        this.stack[++top] = data;
    }

    public Object pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();

        Object poppedData = stack[top];
        stack[top--] = null;

        return poppedData;
    }

    public Object peek(){
        if(isEmpty())
            return null;
        else
            return this.stack[top];
    }
}

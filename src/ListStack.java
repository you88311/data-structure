public class ListStack<T> {
    Node<T> head = null;
    Node<T> buttom = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T data) {
        //스택 맨 위에 요소를 추가
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (!isEmpty()) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    public T pop(){
        //스택 맨 위의 요소를 삭제하며 반환
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException();

        T tmp = this.head.data;
        Node<T> poppedNode = this.head;
        this.head = this.head.next;

        poppedNode.next = null;
        poppedNode.data = null;

        return tmp;
    }

    public T peek(){
        //스택 맨 위의 요소를 삭제하지 않고 반환
        if(isEmpty()){
            return null;
        }
        return this.head.data;
    }
}


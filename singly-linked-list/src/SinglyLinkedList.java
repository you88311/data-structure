public class SinglyLinkedList<T> {

    Node<T> head = new Node<>();
    int length = 0;

    public Node<T> findNode(int searchIndex) {
        if (searchIndex < 0 || this.length <= searchIndex)
            throw new ArrayIndexOutOfBoundsException();

        Node<T> node = head;
        int nodeIndex = 0;

        while (nodeIndex != searchIndex) {
            node = node.next;
            nodeIndex++;
        }

        return node;
    }

    public int getIndex(T data) {
        Node<T> node = this.head;
        for (int i = 0; i < this.length; i++) {
            if (node.data == data)
                return i;
            node = node.next;
        }
        return -1;
    }

    public void add(int index, T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node<T> preNode = findNode(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        this.length++;
    }

    public void addLast(T data) {
        add(length, data);
    }

    public void addFirst(T data) {
        add(0, data);
    }

    public void deleteByIndex(int index) {
        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node<T> preNode = findNode(index - 1);
            preNode.next = preNode.next.next;
        }
        this.length--;
    }

    public void delete(T deleteData ){
        int deleteIndex = getIndex(deleteData);
        deleteByIndex(deleteIndex);
    }

    public void deleteAll() {
        this.head.next = null;
        length = 0;
    }

    public void replace(int index, T data) {
        Node<T> replacingNode = findNode(index);
        replacingNode.data = data;
    }

    public boolean isInList(T data) {
        int index = getIndex(data);
        return index != -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int getLength() {
        return this.length;
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("비어있습니다");
            return;
        }
        Node<T> node = head;
        for (int i = 0; i < this.length; i++) {
            System.out.printf("%d번째 노드: ", i + 1);
            System.out.println(node.data);
            node = node.next;
        }
    }
}

import java.sql.SQLOutput;

public class DoublyLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    int length = 0;

    public Node<T> findNode(int searchIndex) {
        if (searchIndex < 0 || this.length <= searchIndex)
            throw new ArrayIndexOutOfBoundsException();

        int index;
        Node<T> foundNode;

        if (this.length / 2 > searchIndex) {
            index = 0;
            foundNode = this.head;

            while (index != searchIndex) {
                foundNode = foundNode.right;
                index++;
            }
        } else {
            index = this.length - 1;
            foundNode = this.tail;

            while (index != searchIndex) {
                foundNode = foundNode.left;
                index--;
            }
        }
        return foundNode;
    }

    public int indexOf(T data) {
        int foundIndex = 0;
        Node<T> foundNode = this.head;

        while (foundNode != null) {
            if (foundNode.data == null && data == null) {
                //값이 null인 경우 equals()함수 사용 불가하기에 별도 구현
                return foundIndex;
            } else if (data != null && data.equals(foundNode.data)) {
                return foundIndex;
            }
            foundNode = foundNode.right;
            foundIndex++;
        }
        //못 찾은 경우
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public void add(int addIndex, T data) {
        Node<T> addNode = new Node<>();
        addNode.data = data;

        if (this.length == 0) {
            //최초 노드 삽입인 경우
            this.head = addNode;
            this.tail = addNode;
        } else if (addIndex == 0) {
            //맨 앞에 노드 삽입인 경우
            addNode.right = this.head;
            this.head.left = addNode;
            this.head = addNode;
        } else if (addIndex == this.length) {
            //맨 뒤에 노드 삽입인 경우
            addNode.left = this.tail;
            this.tail.right = addNode;
            this.tail = addNode;
        } else {
            //중간에 노드 삽입인 경우

            Node<T> rightNode = findNode(addIndex);
            Node<T> leftNode = rightNode.left;

            addNode.left = leftNode;
            addNode.right = rightNode;
            leftNode.right = addNode;
            rightNode.left = addNode;
        }
        this.length++;
    }

    public void addFirst(T data) {
        add(0, data);
    }

    public void addLast(T data) {
        add(this.length, data);
    }

    public void removeNode(Node<T> removingNode) {
        Node<T> leftNode = removingNode.left;
        Node<T> rightNode = removingNode.right;
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }

        if (this.length == 1) {
            //노드가 한 개인 경우
            this.head = null;
            this.tail = null;
        } else if (leftNode == null) {
            //맨 앞 노드 삭제인 경우
            rightNode.left = null;
            this.head = rightNode;
        } else if (rightNode == null) {
            //맨 뒤 노드 삭제인 경우
            leftNode.right = null;
            this.tail = leftNode;
        } else {
            //중간 노드 삭제인 경우
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        removingNode.left = null;
        removingNode.right = null;
        this.length--;
    }

    public void remove(int removeIndex) {
        removeNode(findNode(removeIndex));
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(length - 1);
    }

    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        if (length == 0) {
            System.out.println("비어있습니다.");
            return;
        }

        Node<T> pointer = this.head;
        System.out.print("현재 이중 연결 리스트에 있는 값: ");
        while (pointer != null) {
            System.out.printf(pointer.data + " ");
            pointer = pointer.right;
        }
        System.out.println();
    }
}

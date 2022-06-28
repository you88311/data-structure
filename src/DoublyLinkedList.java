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

    public void add(int addIndex, T data){
        Node<T> addNode = new Node<>();
        addNode.data = data;

        if(this.length ==0){
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
        }else{
            //중간에 노드 삽입인 경우
            Node<T> leftNode = findNode(addIndex);
            Node<T> rightNode = leftNode.right;

            addNode.left = leftNode;
            addNode.right = rightNode;
            leftNode.right = addNode;
            rightNode.left = addNode;
        }
        this.length++;
    }

}

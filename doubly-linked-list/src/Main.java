public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst("A");
        doublyLinkedList.addLast("B");
        doublyLinkedList.addLast("D");
        doublyLinkedList.addLast("E");
        doublyLinkedList.add(2, "C");
        doublyLinkedList.display();

        System.out.println("값 C 갖는 노드의 index: " + doublyLinkedList.indexOf("C"));
        System.out.println("List는 값 E를 값고 있다: " + doublyLinkedList.contains("E"));
        System.out.println("List는 값 F를 값고 있다: " + doublyLinkedList.contains("F"));

        doublyLinkedList.remove(1);
        doublyLinkedList.display();

        doublyLinkedList.removeFirst();
        doublyLinkedList.display();

        doublyLinkedList.removeLast();
        doublyLinkedList.display();

        doublyLinkedList.removeAll();
        doublyLinkedList.display();

//        doublyLinkedList.remove(0);
//        Node<String> node = new Node<String>();
//        doublyLinkedList.removeNode(node);
          //없는 값을 삭제하려고 하기에 ArrayIndexOutOfBoundsException 발생시킴

    }
}

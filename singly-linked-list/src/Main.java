public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("A");
        list.add(1,"B");
        list.add(2,"C");
        list.add(3,"D");
        list.addLast("E");
        list.display();
        System.out.println();

        System.out.println("A의 index: " + list.getIndex("A"));
        System.out.println("E의 index: " + list.getIndex("E"));

        System.out.printf("\nA가 있는지?: " + list.isInList("A"));
        System.out.printf("\nF가 있는지?: " + list.isInList("F") + "\n\n");

        list.replace(0, "1");
        list.replace(2, "3");
        list.replace(4, "5");
        list.display();

        System.out.print("\n값이 5인 index4 노드 삭제 ");
        list.deleteByIndex(4);
        System.out.printf("\n5가 있는지: "+list.isInList("5") + "\n");

        System.out.printf("\nisEmpty?: " + list.isEmpty() + "\n");
        System.out.println("deleteAll()함수로 전체 삭제");
        list.deleteAll();
        System.out.printf("isEmpty?: " + list.isEmpty() + "\n");

    }
}

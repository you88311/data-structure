public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");
        list.add(0, "D");
        list.add(0, "E");
        list.showAll();

        System.out.println("-------------------------");
        list.deleteAll();
        list.showAll();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        list.addFirst("E");
        list.showAll();

        System.out.println("-------------------------");
        list.deleteAll();
        list.showAll();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.showAll();
        System.out.println();

        System.out.println("A의 index: " + list.getIndex("A"));
        System.out.println("B의 index: " + list.getIndex("B"));
        System.out.println("C의 index: " + list.getIndex("C"));
        System.out.println("D의 index: " + list.getIndex("D"));
        System.out.println("E의 index: " + list.getIndex("E"));

        System.out.printf("\nLength: " + list.getLength() + "\n");

        System.out.printf("\nA가 있는지?: " + list.isInList("A"));
        System.out.printf("\nC가 있는지?: " + list.isInList("C"));
        System.out.printf("\nE가 있는지?: " + list.isInList("E"));
        System.out.printf("\nF가 있는지?: " + list.isInList("F") + "\n\n");

        list.replace(0, "1");
        list.replace(2, "3");
        list.replace(4, "5");
        list.showAll();

        System.out.printf("\n값이 5인 index4 노드 삭제 ");
        list.deleteByIndex(4);
        System.out.printf("\n5가 있는지: "+list.isInList("5") + "\n");

        System.out.printf("\nisEmpty?: " + list.isEmpty() + "\n");
        list.deleteAll();
        list.showAll();
        System.out.printf("isEmpty?: " + list.isEmpty() + "\n");

    }
}

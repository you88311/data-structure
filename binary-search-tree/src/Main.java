public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(12);
        bst.add(8);
        bst.add(7);
        bst.add(5);
        bst.add(10);
        bst.add(9);
        bst.add(11);
        bst.add(17);
        bst.add(14);
        bst.add(20);
        bst.ascendingTraversal();
        bst.descendingTraversal();

        bst.remove(12);
        bst.ascendingTraversal();
        bst.descendingTraversal();

    }

}

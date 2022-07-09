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

        System.out.println("key 12 갖는 노드 삭제");
        bst.remove(12);

        bst.ascendingTraversal();
        bst.descendingTraversal();

        bst.search(11);
        //트리에 없는 key 찾으려 하여 오류 발생
//        bst.search(12);
    }

}

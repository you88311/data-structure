public class BinarySearchTree {
    Node root = null;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }

    private Node addNode(Node node, Node newNode) {
        if (node == null)
            return newNode;
        else if (node.key > newNode.key)
            node.left = addNode(node.left, newNode);
        else
            node.right = addNode(node.right, newNode);

        return node;
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private Node removeNode(Node node, int key) {
        if (node == null)
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");

        if (node.key > key)
            node.left = removeNode(node.left, key);
        else if (node.key < key) {
            node.right = removeNode(node.right, key);
        } else {
            //삭제할 노드를 찾은 경우
            if (node.left != null) {
                //왼쪽 서브트리에서 가장 오른쪽에 있는 값 찾아 대체하기
                Node child = findMaxNode(node.left);
                int removedKey = node.key;
                node.key = child.key;
                child.key = removedKey;
                //다시 옮겨진 위치에서 서브트리에 대해 재귀적으로 실행
                node.left = removeNode(node.left, key);
            } else if (node.right != null) {
                //오른족 서브트리에서 가장 왼쪽에 있는 값 찾아 대체하기
                Node child = findMinNode(node.right);
                int removedKey = node.key;
                node.key = child.key;
                child.key = removedKey;
                //다시 옮겨진 위치에서 서브트리에 대해 재귀적으로 실행
                node.right = removeNode(node.right, key);
            } else {
                //삭제할 노드가 단말 노드인 경우 부모 노드와의 연결 종료
                return null;
            }
        }

        return node;
    }

    private Node findMaxNode(Node node) {
        if (node.right == null)
            return node;
        else
            return findMaxNode(node.right);
    }

    private Node findMinNode(Node node) {
        if (node.left == null)
            return node;
        else
            return findMinNode(node.left);
    }

    public void search(int key) {
        searchNode(root, key);
    }

    private Node searchNode(Node node, int key) {
        if (node == null)
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");

        if (node.key > key)
            node.right = searchNode(node.right, key);
        else if (node.key < key)
            node.left = searchNode(node.left, key);
        else
            System.out.println("해당 값을 가진 노드를 찾았습니다.");

        return node;
    }

    public void descendingTraversal() {
        //내림차순 순회
        System.out.print("내림차순 순회: ");
        rightInorderTraversal(root);
        System.out.println();
    }

    private void rightInorderTraversal(Node node){
        //우측 중위 순회
        if(node == null)
            return;
        rightInorderTraversal(node.right);
        System.out.printf("%d ", node.key);
        rightInorderTraversal(node.left);
    }


    public void ascendingTraversal() {
        //오름차순 순회
        System.out.print("오름차순 순회: ");
        leftInorderTraversal(root);
        System.out.println();
    }

    private void leftInorderTraversal(Node node) {
        //좌측 중위 순회
        if(node == null)
            return;
        leftInorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        leftInorderTraversal(node.right);
    }

}

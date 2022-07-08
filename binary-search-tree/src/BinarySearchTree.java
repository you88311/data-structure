public class BinarySearchTree {
    Node  root = null;

    public void add(int key){
        Node newNode = new Node();
        newNode.key = key;

        if(root == null){
            root = newNode;
        }else {
            root = insertNode(root, newNode);
        }
    }

    private Node insertNode(Node node, Node newNode){
        if(node == null)
            return newNode;
        else if(node.key > newNode.key)
            node.left = insertNode(node.left, newNode);
        else
            node.right = insertNode(node.right, newNode);

        return node;
    }

    public void remove(int key){

    }

    private Node removeNode(Node node, int key){
        if(node == null)
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");

        if(node.key > key)
            node.right = removeNode(node.right, key);
        else if (node.key < key) {
            node.left = removeNode(node.left, key);
        }else {
            //삭제할 노드를 찾음
            if(node.left != null){
                Node child = findMaxNode(node.left);
                Node tmp = child;
                child = node;
                node = tmp;
            } else if (node.right != null) {
                Node child = findMinNode(node.right);
            }else {
                return null;
            }
        }

        return node;
    }

    private Node findMaxNode(Node node){
        if(node.right == null)
            return node;
        else
            return findMaxNode(node.right);
    }

    private Node findMinNode(Node node){
        if(node.left == null)
            return node;
        else
            return findMinNode(node.left);
    }


}

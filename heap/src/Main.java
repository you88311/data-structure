public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(50);
        heap.add(12);
        heap.add(11);
        heap.add(10);
        heap.add(9);
        heap.add(7);
        heap.add(4);
        heap.add(1);
        heap.add(5);
        heap.printHeap();

        heap.peek();
        heap.delete();
        heap.peek();
        heap.printHeap();
    }
}

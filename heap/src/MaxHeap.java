import java.util.Arrays;

public class MaxHeap {
    Integer[] queue;
    final int ROOT_NODE_INDEX = 0;
    int size = 0; // 저장된 노드의 개수

    public MaxHeap(int length) {
        queue = new Integer[length];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return size > getLeftChildIndex(index);
    }

    private boolean hasRightChild(int index) {
        return size > getRightChildIndex(index);
    }

    private void swap(int index1, int index2) {
        Integer tmp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = tmp;
    }

    public void add(Integer key) {
        if (queue.length == size)
            queue = Arrays.copyOf(queue, queue.length + 10);

        queue[size++] = key;
        upHeap(size - 1);
        System.out.println(key + " 삽입 완료");
    }

    public void upHeap(int index) {
        while (index != ROOT_NODE_INDEX && queue[index] > queue[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public void delete() {
        int leafNodeIndex = size - 1;
        swap(ROOT_NODE_INDEX, leafNodeIndex);
        System.out.println(queue[leafNodeIndex] + " 삭제");
        queue[leafNodeIndex] = null;
        size--;
        DownHeap(ROOT_NODE_INDEX);

    }

    public void DownHeap(int index) {
        int childIndex;

        if(hasLeftChild(index))
            childIndex = getBiggerChildIndex(index);
        else
            return;

        while (size > index && hasLeftChild(index) && queue[index] < queue[childIndex]) {
            swap(index, childIndex);
            index = childIndex;
            childIndex = getBiggerChildIndex(index);
        }
    }

    private int getBiggerChildIndex(int index) {
        if (hasRightChild(index))
            return (queue[getLeftChildIndex(index)] >= queue[getRightChildIndex(index)]) ? getLeftChildIndex(index) : getRightChildIndex(index);
        else if (hasLeftChild(index))
            return getLeftChildIndex(index);
        else//자식 노드가 없는 단말 노드인 경우
            return -1;
    }

    public void peek() {
        System.out.println("다음 값은: " + queue[ROOT_NODE_INDEX]);
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", queue[i]);
        }
        System.out.println();
    }
}

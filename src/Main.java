public class Main {
    public static void main(String[] args) {
        System.out.println("------Stack으로 구현한 Queue------");
        StackQueue stackQueue = new StackQueue(100);
        int numberOfData = 5;

        for (int i = 0; i < numberOfData; i++) {
            stackQueue.enqueue(i);
            System.out.printf("%d를 Queue에 enqueue\n", i);
        }

        System.out.println("peek연산 결과: " + stackQueue.peek());

        for (int i = 0; i < numberOfData; i++) {
            System.out.print(stackQueue.dequeue() + " ");
        }

        //ArrayIndexOutOfBoundsException예외 발생
//        System.out.println(stackQueue.dequeue());


        System.out.println("\n------List로 구현한 Queue------");
        ListQueue<Integer> listQueue = new ListQueue();

        for (int i = 0; i < numberOfData; i++) {
            listQueue.enqueue(i);
            System.out.printf("%d를 Queue에 enqueue\n", i);
        }
        System.out.println("peek연산 결과: " + listQueue.peek());

        for (int i = 0; i < numberOfData; i++) {
            System.out.print(listQueue.dequeue() + " ");
        }

        //큐가 비어있는데 dequeue하려는 경우
        System.out.println(listQueue.dequeue());
    }


}

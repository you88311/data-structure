public class Main {
    public static void main(String[] args) {
        System.out.println("배열로 구현한 stack");
        ArrayStack arrayStack = new ArrayStack(1000);
        System.out.println("1,2,3,4,5 순으로 push()");
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        System.out.print("stack 가장 위에 있는 데이터: ");
        System.out.println(arrayStack.peek());

        int arrayindex = arrayStack.top;
        for (int i = 0; i <= arrayindex; i++) {
            System.out.print("pop된 데이터: ");
            System.out.println(arrayStack.pop());
        }

        //ArrayIndexOutOfBoundsException 예외 발생
//        System.out.printf("pop된 데이터: ");
//        System.out.println(arrayStack.pop());

        System.out.println("----------------------------------------------");
        System.out.println("list로 구현한 stack");
        ListStack<Integer> listStack = new ListStack<>();

        System.out.println("1,2,3,4,5 순으로 push()");
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);

        System.out.print("stack 가장 위에 있는 데이터: ");
        System.out.println(listStack.peek());
        
        while(!listStack.isEmpty()){
            System.out.print("pop된 데이터: ");
            System.out.println(listStack.pop());
        }

        //ArrayIndexOutOfBoundsException 예외 발생
//        System.out.print("pop된 데이터: ");
//        System.out.println(listStack.pop());

    }
}

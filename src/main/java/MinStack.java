import java.util.Stack;

public class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if (s1.isEmpty() || s1.peek() >= val) {
            s1.push(val);
            s2.push(val);
        } else {
            s1.push(s1.peek());
            s2.push(val);
        }
    }

    public void pop() {
        s2.pop();
        s1.pop();
    }

    public int top() {
        // return s2.peek();
        return s2.peek();
    }

    public int getMin() {
        return s1.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        /**********************************
         * Test 1
         *******************************************/
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int val1 = minStack.getMin();
        System.out.printf("Test 1 - Expected: -3, 0, -2 Getting: %d", val1);
        minStack.pop();
        int val2 = minStack.top();
        System.out.printf(" %d", val2);
        int val3 = minStack.getMin();
        System.out.printf(" %d\n", val3);
        /*******************************************
         * Test 2
         *******************************************/
        minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        val1 = minStack.getMin();
        System.out.printf("Test 2 - Expected: [-1024,-1024,512] Getting: %d", val1);
        minStack.pop();
        val2 = minStack.getMin();
        System.out.printf(" %d", val2);
        minStack.pop();
        val3 = minStack.getMin();
        System.out.printf(" %d\n", val3);
        /*******************************************
         * Test 3
         *******************************************/
        minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        val1 = minStack.getMin();
        System.out.printf("Test 3 - Expected: [-2,-1,-2] Getting: val1: %d", val1);
        val2 = minStack.top();
        System.out.printf(" val2: %d", val2);
        minStack.pop();
        val3 = minStack.getMin();
        System.out.printf(" val3: %d\n", val3);
        /*******************************************
         * Test 4
         *******************************************/
        minStack = new MinStack();
        minStack.push(-1);
        val1 = minStack.top();
        System.out.printf("Test 4 - Expected: [-1,-1,1,-1], Getting: %d ", val1);
        val2 = minStack.getMin();
        System.out.printf("%d ", val2);
        minStack.push(1);
        val3 = minStack.top();
        System.out.printf("%d ", val3);
        int val4 = minStack.getMin();
        System.out.printf("%d \n", val4);
        /*******************************************
         * Test 5
         *******************************************/
        minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        val1 = minStack.getMin();
        System.out.printf("Test 5 - Expected: [-3,0,-2], Getting: %d", val1);
        minStack.pop();
        val2 = minStack.top();
        System.out.printf(" %d", val2);
        val3 = minStack.getMin();
        System.out.printf(" %d\n", val3);
        /*******************************************
         * Test 6
         *******************************************/
        minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(2);
        minStack.push(0);
        val1 = minStack.getMin();
        System.out.printf("Test 6 - Expected: [0,0,0,2], Getting: %d", val1);
        minStack.pop();
        val2 = minStack.getMin();
        System.out.printf(" %d", val2);
        minStack.pop();
        val3 = minStack.getMin();
        System.out.printf(" %d", val3);
        minStack.pop();
        val4 = minStack.getMin();
        System.out.printf(" %d\n", val4);
    }
}

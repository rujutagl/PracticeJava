import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else {
            stack2.push(Math.min(stack2.peek(), val));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
       return stack2.pop();
    }
}

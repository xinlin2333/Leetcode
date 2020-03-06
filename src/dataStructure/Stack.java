package dataStructure;

public class Stack {
    private int size;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
        this.size = size;
    }

    //入栈
    public void push(int elem) {
        stackArray[++top] = elem;
    }

    //出栈
    public int pop() {
        return stackArray[top--];
    }

    //查看栈顶元素
    public int peek() {
        return stackArray[top];
    }

    //empty
    public boolean isEmpty() {
        return (top == -1);
    }

    //full
    public boolean isFull() {
        return (top == size - 1);
    }
}

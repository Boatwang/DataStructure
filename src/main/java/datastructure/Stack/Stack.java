package main.java.datastructure.Stack;

/**
 * 栈:先入后出的结构,是一种限制线性表中元素的插入和删除只能在线性表的同一端进行的特殊线性表
 */

public class Stack {
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;//top表示栈顶，初始化为-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull(){
        return top == maxSize -1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 入栈
     */
    public void push(int value){
        if (isFull()){
            System.out.println("栈满，无法存入");
        }
        stack[++top] = value;
    }

    /**
     *
     */
    public int pop(){
        if (isEmpty()){
            System.out.println("栈满,无数据可出");
        }
         return stack[top--];
    }
}
package main.java.datastructure.queue;

public class CircleQueue {

    public int[] queue;
    public int maxSize;
    //front指向队列的第一个元素,给初始值为0,取完当前front的元素-->front+1
    public int front;
    //rear指向队列中最后一个元素的后一位,给初始值为0
    public int rear;

    /**
     * 初始化队列
     * @param maxSize
     */
    public void  initialize(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear=1;
        front=0;
        System.out.println("初始化队列已完成 队列的最大储存数为:"+maxSize);
    }
    /**
     * 判断队列是否为空
     * 我认为判断循环队列是否为空就是看是否front在rear的紧邻下面但是因为这又是一个循环队列,所以需要用到"%"
     */
    public boolean isEmpty(){
        return front==rear;
    }

    /**
     * 判断队列是否为满
     * 判断队列是否为满就是看rear是否在front下面,由于是循环队列所以需要用到"%"
     */
     public boolean isFull(){
         return (rear+1)%maxSize==front;
     }

    /**
     * 判断队列中有效元素的个数
     * @return
     */
     public int getValidCount(){
         return (rear+maxSize-front)%maxSize;
     }
}


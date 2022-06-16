package main.java.datastructure.queue;

public class Queue {
    public static void main(String[] args) {

        Queue myQueue = new Queue();
        myQueue.initialize(6);
        myQueue.add(8);
        int i = myQueue.get();
        System.out.println("取出元素" + i);
    }

    public int[] queue;
    public int maxSize;
    public int front;
    public int rear;

    /**
     * 初始化队列
     */
    public void initialize(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = 0;
        front = 0;
        System.out.println("初始化队列已完成 队列的最大储存数为:" + maxSize);
    }

    /**
     * 向队列内添加元素
     */
    public void add(int element) {
        if (rear >= (maxSize - 1)) {
            System.out.println("队列已满 无法取出元素");
            return;
        }
        queue[rear++] = element;
        System.out.println("元素" + element + "加入队列成功 ");
    }

    /**
     * 取出队列内的元素
     */
    public int get() {
        return queue[front++];
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear >= (maxSize - 1));
    }
    /**
     * 判断队列中有效的元素的个数
     */
    public int getValidCount(){
        return rear-front;
    }
}

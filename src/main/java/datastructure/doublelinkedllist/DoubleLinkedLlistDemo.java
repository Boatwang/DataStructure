package main.java.datastructure.doublelinkedllist;

/**
 * 双向链表
 * 优点：可以找到前驱和后继，可进可退；
 * 缺点：增加删除节点复杂，多需要分配一个指针存储空间。
 */
public class DoubleLinkedLlistDemo {
    public static void main(String[] args) {


        HeroNode heroNode1 = new HeroNode(1, "老李", "整挺好");
        HeroNode heroNode2 = new HeroNode(2, "老王", "整挺爽");
        HeroNode heroNode3 = new HeroNode(3, "老赵", "整挺坏");
        DoubleLinkedList doubleLinkedLlist = new DoubleLinkedList();
        doubleLinkedLlist.addNodeToEnd(heroNode1);
        doubleLinkedLlist.addNodeToEnd(heroNode2);
        doubleLinkedLlist.addNodeToEnd(heroNode3);
        doubleLinkedLlist.showList();
        doubleLinkedLlist.delById(2);
        System.out.println("__________________");
        doubleLinkedLlist.showList();
        doubleLinkedLlist.delById(3);
        System.out.println("__________________");
        doubleLinkedLlist.showList();
        doubleLinkedLlist.delById(3);
        System.out.println("__________________");
        doubleLinkedLlist.showList();
        doubleLinkedLlist.delById(1);
        System.out.println("___________________");
        doubleLinkedLlist.showList();


    }


}

class DoubleLinkedList{
    HeroNode headNode = new HeroNode(0,"","");

    /**
     * 返回头结点
     */
    public HeroNode getHead(){
        return headNode;
    }

    /**
     * 遍历双向链表
     */
    public void showList(){
        if (headNode.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode.next;
        while (true){
            if (temp.next==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 添加到双向链表的末端
     */
    public void addNodeToEnd(HeroNode newNode){
        HeroNode temp = headNode;
        while (true){
            if (temp.next==null){
                break;
            }else {
                temp=temp.next;
            }
        }
        temp.next=newNode;
        newNode.pre=temp;
    }

    /**
     * 根据"no"删除节点
     */
    public void delById(int no){

        if (headNode.next==null){
            System.out.println("空链表,无数据");
            return;
        }

        HeroNode temp = headNode.next;
        boolean flag = false;

        while (true){
            if(temp.no==no){
                flag = true;
                break;
            }else if (temp.next==null) {
                break;
            }else {
                temp = temp.next;

            }
        }

        if (flag==true){
            if (temp.next==null){
                temp.pre.next=null;
            }else {
                temp.pre.next =  temp.next;
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.println("双向链表中无该数据");
        }
    }


}


class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode pre;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
}
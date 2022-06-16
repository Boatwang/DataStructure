package main.java.datastructure.linkedlsit;

/**
 *
 * 单链表
 * 优点：单向链表增加删除节点简单。遍历时候不会死循环；
 * 缺点：- 只能从头到尾遍历。只能找到后继，无法找到前驱，也就是只能前进。
 *      - 需要靠辅助删除,不能自我删除
 *
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "老李", "整挺好");
        HeroNode heroNode2 = new HeroNode(2, "老王", "整挺爽");
        HeroNode heroNode3 = new HeroNode(3, "老赵", "整挺坏");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(heroNode1);
        singleLinkedList.addNode(heroNode2);
        singleLinkedList.addNode(heroNode3);
        singleLinkedList.showList();
        System.out.println("_________________");
        singleLinkedList.delByNo(2);
        singleLinkedList.showList();

    }
}


class SingleLinkedList{

    //单向链表的头结点
    private HeroNode headNode = new HeroNode(0,"","");

    /**
     * 根据no删除元素
     */
    public void delByNo(int no){
        HeroNode temp = headNode;
        while (true){
            if (temp.next==null){
                System.out.println("空表,无数据");
                break;
            }else if (temp.next.no==no){
                temp.next=temp.next.next;
                break;
            }else if (temp.next.no!=no){
                temp=temp.next;
            }
        }

    }

    /**
     * 根据排名插入指定位置
     */
    public void addByOrder(HeroNode newNode){
        HeroNode temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                break;
            }else if (temp.next.no>newNode.no){
                break;
            }else if (temp.next.no==newNode.no){
                flag=true;
                break;
            }else if (temp.next.no<newNode.no){
                temp = temp.next;
            }
        }

        if (flag==false){
            newNode.next = temp.next;
            temp.next = newNode;
        }else {
            System.out.println("该编号已存在，插入失败");
        }

    }
    /**
     * 添加节点到单项列表
     */
    public void addNode(HeroNode newNode){
        //headNode不要动,复制一份辅助头结点进行便利
        HeroNode temp = headNode;

        while (true){
            if (temp.next==null){
                break;
            }
            /**
             * 如果temp.next!=null,说明还不是目前链表的最后一个,所以temp链表需要后移
             */
            temp = temp.next;//不是整个数据都复制过去,只是复制的该对象的链接
        }
        temp.next = newNode;
    }

    /**
     * 显示链表
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
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

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
package main.java.datastructure.tree;

/**
 * 为什么要用树存储结构
 * 1.数组存储结构优缺点：
 * - 优点：通过下标访问元素，速度快，对于有序数组，还可以通过二分查找以提高访问速度
 * - 缺点：- 插入数据和删除数据时效率低
 * - 扩容效率低
 * 2.链式存储结构优缺点：
 * - 优点：插入和删除的效率高
 * - 缺点：进行检索时效率低，需要从头节点开始检索
 * 3.树存储结构的优缺点
 * - 优点：数据的存储和读取的效率较高，二叉排序树可以保证数据的检索速度，数据的插入，删除和修改的速度
 * - 缺点：- 顺序存储可能会浪费空间(在非完全二叉树的时候)，但是读取某个指定的节点的时候效率比较高O(0)
 * - 链式存储相对二叉树比较大的时候浪费空间较少，但是读取某个指定节点的时候效率偏低O(nlogn)
 * <p>
 * 树的术语：- 叶子节点：没有子节点的节点
 * - 节点的权：节点本身的值
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode heroNode0 = new HeroNode(0, "");
        HeroNode heroNode1 = new HeroNode(1, "");
        HeroNode heroNode2 = new HeroNode(2, "");
        HeroNode heroNode3 = new HeroNode(3, "");
        HeroNode heroNode4 = new HeroNode(4, "");
        HeroNode heroNode5 = new HeroNode(5, "");

        heroNode0.setLeft(heroNode1);
        heroNode0.setRight(heroNode4);

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);

        heroNode4.setLeft(heroNode5);

        binaryTree.setRoot(heroNode0);
        System.out.println("后序遍历");
        binaryTree.postOrder();
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();


    }

}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root=root;
    }

    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("空二叉树，无数据");
        }
    }

    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("空二叉树，无数据");
        }
    }

    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("空二叉树，无数据");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode right;
    private HeroNode left;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);//输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

}

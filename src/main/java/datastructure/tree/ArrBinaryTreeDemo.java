package main.java.datastructure.tree;

/**
 * 顺序存储二叉树
 * - 顺序存储二叉树通常只考虑完全二叉树
 * - 第n个元素的左子节点对应数组（数组下标从0开始）的第（2n+1）个元素
 * - 第n个元素的右子节点对应数组（数组下标从0开始）的第（2n+2）个元素
 * - 第n个元素的右父节点对应数组（数组下标从0开始）的第（（n-1/2））个元素
 * - 详见项目根目录下readme/images
 */

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("进行前序遍历");
        arrBinaryTree.preOrder(0);//结果：1.2.4.5.3.6.7

        System.out.println("进行中序遍历");
        arrBinaryTree.infixOrder(0);//4.2.6.1.6.3.7

        System.out.println("进行后序遍历");
        arrBinaryTree.postOrder(0);//4.5.2.6.7.3.1

    }
}

class ArrBinaryTree{
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr){
        this.arr =arr;
    }

    /**
     * 顺序存储二叉树的前序遍历
     */
    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，无法进行前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    /**
     * 顺序存储二叉树的中序遍历
     */
    public void infixOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，无法进行前序遍历");
        }
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }

    /**
     * 顺序存储二叉树的后序遍历
     */
    public void postOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空，无法进行前序遍历");
        }
        if ((index*2+1)<arr.length){
            postOrder(index*2+1);
        }
        if ((index*2+2)<arr.length){
            postOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}

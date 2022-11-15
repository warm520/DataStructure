package com.chy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 10:59
 */
public class Code_isBST {
    public static class Node {
        public int value;
        public  Node left;
        public  Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class ReturnData{
        public boolean isBST;
        public int max;
        public int min;
        public ReturnData(boolean isB,int ma,int mi){
            isBST = isB;
            max = ma;
            min = mi;
        }

    }
    public static int preValue = Integer.MIN_VALUE;

    /**
     * 首先检查左树是否为搜索二叉树然后检查右树
     * @param head
     * @return
     */
    public static boolean checkBST(Node head){
        if(head==null){
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if(!isLeftBst){
            return false;
        }else{
            preValue = head.value;
        }
        return checkBST(head.right);
    }
    public static boolean checkBST2(Node head){
        if(head==null){
            return true;
        }
        LinkedList<Node> linkedList = new LinkedList<Node>();
//        中序遍历二叉树
        process(head,linkedList);
        int pre = Integer.MIN_VALUE;
        for(Node cur:linkedList){
            if(pre>=cur.value){
                return false;
            }
            pre = cur.value;
        }
        return true;
    }
    public static void process(Node node, LinkedList<Node> inOrderList){
        if(node==null){
            return;
        }
        process(node.left,inOrderList);
        inOrderList.add(node);
        process(node.right,inOrderList);
    }
    public static boolean checkBST3(Node head){
        int preValue = Integer.MIN_VALUE;
        if(head!=null){
            Stack<Node> stack = new Stack();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(head.value <= preValue){
                        return false;
                    }
                    preValue = head.value;
                    head = head.right;
                }
            }
        }
        return true;
    }
//    递归的方式
    /*
    寻找树的左树的最大值，右树的最小值
     */
    public static ReturnData process(Node head){
        if(head == null){
            return null;
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        int min = head.value;
        int max = head.value;
        if(leftData!=null){
            min = Math.min(leftData.min,min);
            max = Math.max(leftData.max,max);
        }
        if(rightData!=null){
            min = Math.min(rightData.min,min);
            max = Math.max(rightData.max,max);
        }
        boolean isBST = true;
        if(leftData!=null && (!leftData.isBST || leftData.max>=head.value)){
            isBST = false;
        }
        if(rightData!=null && (!rightData.isBST || rightData.min<=head.value)){
            isBST = false;
        }
        return new ReturnData(isBST,max,min);
    }
}

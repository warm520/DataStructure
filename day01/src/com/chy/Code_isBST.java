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
}

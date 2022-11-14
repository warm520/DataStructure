package com.chy;

import java.util.Stack;

/**
 * @description
 * @autor chy
 * @create 2022--11--14 16:08
 */
public class Code_PreInPost {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
//    先序打印

    /**
     * 1.先将head添加到栈中
     * 2.弹出一个元素
     * 3.先右再左(如果有)压入栈中
     * 4.返回第二部
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value+ " ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
//    中序打印
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if(head!=null){
            Stack<Node> stack = new Stack();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
//    后序打印1
    public static void posOrderUnRecur1(Node head){
        System.out.println("post-order: ");
        if(head!=null){
//            准备两个栈
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left!=null){
                    stack1.push(head.left);
                }
                if(head.right!=null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.println(stack2.pop().value+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

//        // recursive
//        System.out.println("==============recursive==============");
//        System.out.print("pre-order: ");
////        preOrderRecur(head);
//        System.out.println();
//        System.out.print("in-order: ");
////        inOrderRecur(head);
//        System.out.println();
//        System.out.print("pos-order: ");
////        posOrderRecur(head);
//        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);
    }
}

package com.chy;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 16:43
 */
/*
平衡二叉树:对于任意一棵树,左侧树是平衡树，右侧树是平衡树，左侧树的高度差与右侧树的高度差不超过1
 */
public class Code_IsBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Boolean isBalanced(Node head){
        return process(head).isBalanced;
    }
    public static class ReturnType{
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isB,int h){
            isBalanced = isB;
            height = h;
        }
    }
    public static ReturnType process(Node head){
        if(head==null){
            return new ReturnType(true,0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);

        int height = Math.max(leftData.height,rightData.height)+1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height-rightData.height)<2;
        return new ReturnType(isBalanced,height);
    }
}

package com.chy;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 17:32
 */
public class Code_isFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class ReturnData {
        public int height;
        public int nodes;
        public ReturnData(int h,int n){
            height = h;
            nodes = n;
        }
    }
    public static boolean isFull(Node head){
        if(head==null){
            return true;
        }
        ReturnData data = process(head);
        return data.nodes == (1 << data.height - 1);
    }
    public static ReturnData process(Node head){
        if(head==null){
            return new ReturnData(0,0);
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        int height = Math.max(leftData.height,rightData.height)+1;
        int width = leftData.nodes+rightData.nodes +1;
        return new ReturnData(height,width);
    }
}

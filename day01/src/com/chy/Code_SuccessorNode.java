package com.chy;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 20:59
 */
public class Code_SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }
        if(node.right != null){//节点有右树
            return getLeftMost(node.right);
        }else{
            Node parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    public static Node getLeftMost(Node head){
        if(head == null){
            return null;
        }
        while(head.left != null){
            head = head.left;
        }
        return head;
    }
}

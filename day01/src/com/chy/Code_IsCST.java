package com.chy;

import java.util.LinkedList;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 16:31
 */
public class Code_IsCST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static boolean isCST(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> linkedList = new LinkedList<Node>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        linkedList.add(head);
        while(!linkedList.isEmpty()){
            head = linkedList.poll();
            l = head.left;
            r = head.right;
//            如果遇到不双全的节点后，又发现当前节点不是叶节点
            if((leaf&&(l!=null||r!=null))||(l==null&&r!=null)){
                return false;
            }
            if(l!=null){
                linkedList.add(l);
            }
            if(r!=null){
                linkedList.add(r);
            }
            if(l==null||r==null){
                leaf = true;
            }
        }
        return true;
    }
}

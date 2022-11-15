package com.chy;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description
 * @autor chy
 * @create 2022--11--14 17:11
 */
public class Code_TreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static int getMaxWidth(Node head){
        if(head==null){
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;//当前最大宽度
        int curLevel = 0;//当前遍历层数
//        产生一个hashmap 存放节点 当前层数
        HashMap<Node,Integer> levelMap = new HashMap<Node,Integer>();
        levelMap.put(head,1);
//        产生一个队列,存放树的所有数据
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;
            if(left!=null){
                levelMap.put(left,levelMap.get(node)+1);
                queue.add(left);
            }
            if(right!=null){
                levelMap.put(right,levelMap.get(node)+1);
                queue.add(right);
            }
            if(levelMap.get(node)>curLevel){
                curWidth = 0;
                curLevel = levelMap.get(node)+1;
            }else{
                curWidth++;
            }
            maxWidth = Math.max(curWidth,maxWidth);
        }
        return maxWidth;
    }
    public static void main(String[] args) {

    }
}

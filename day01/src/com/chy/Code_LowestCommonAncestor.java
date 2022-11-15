package com.chy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description
 * @autor chy
 * @create 2022--11--15 18:05
 */
public class Code_LowestCommonAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node lca(Node head,Node o1,Node o2){
        HashMap<Node,Node> fatherMap = new HashMap<Node,Node>();
        fatherMap.put(head,head);
        process(head,fatherMap);
        HashSet<Node> set1 = new HashSet<Node>();
        set1.add(o1);
        Node cur = o1;
        while(cur!=fatherMap.get(cur)){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = o2;
        while(cur != fatherMap.get(cur)){
            if(set1.contains(cur)){
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return null;
    }
    public static void process(Node head, HashMap<Node,Node> fatherMap){
        if(head==null){
            return ;
        }
        fatherMap.put(head.left,head);
        fatherMap.put(head.right,head);
        process(head.left,fatherMap);
        process(head.right,fatherMap);
    }
    public static Node lca2(Node head,Node o1,Node o2){
        if(head==null || head == o1 || head == o2){
            return head;
        }
        Node left = lca2(head.left,o1,o2);
        Node right = lca2(head.right,o1,o2);

        if(left != null && right != null){
            return head;
        }
        return left != null ? left : right;
    }
}

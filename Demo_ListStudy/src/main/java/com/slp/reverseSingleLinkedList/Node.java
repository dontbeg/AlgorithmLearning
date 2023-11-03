package com.slp.reverseSingleLinkedList;

/**
 * @Author shenlp
 * @Date 2023/10/25 16:53
 * @Description:结点类
 **/
public class Node {
    int n;
    Node next;

    public Node(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Node{" +
                "n=" + n +
                '}';
    }
}

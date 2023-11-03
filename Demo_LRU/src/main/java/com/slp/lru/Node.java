package com.slp.lru;

/**
 * @Author shenlp
 * @Date 2023/10/31 15:58
 * @Description:结点
 **/
public class Node {
    //结点属性，存在的键值对
    public int key;
    public int value;

    //前置结点
    public Node next;
    //后置结点
    public Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

package com.slp.lru;

/**
 * @Author shenlp
 * @Date 2023/10/31 16:06
 * @Description:关于Node结点的双向链表的实现
 * 1.需要头尾部结点
 * 2.需要size
 * 3.需要实现下列方法：addFrist/removeLast/remove/size方法
 **/
public class DoubleList {
    //头部结点
    private Node head;

    //尾部结点
    private Node tail;

    //列表大小
    private int size;

    //构造方法，实现实体类
    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        //直接初始化了一个双向链表
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 添加一个结点到队首
     * @param node
     */
    public void addFrist(Node node){

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        size ++ ;
    }

    /**
     * 删除最后一个结点
     * @return 返回删除的结点
     */
    public Node removeLast(){
        //判断下是否只有头尾结点
        if(head.next == tail) return  null;
        //直接找到最后一个结点前一个便是last结点
        Node last = tail.prev;
        //改变连接
        last.prev.next = tail;
        tail.prev = last.prev;
        size --;
        return last;
    }

    /**
     * 删除某个结点
     * @param node
     * @return 返回删除的结点
     */
    public Node remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size -- ;
        return node;
    }
    /**
     * 获取当前链表大小
     * @return 链表大小
     */
    public int size(){
        return size;
    }
    /**
     * 打印该链表
     */
    public void print(){
        Node current = head.next;
        while(current != tail){
            System.out.print(current.key+"->"+ current.value+" ");
            current = current.next;
        }
        System.out.println();
    }
}

package com.slp.reverseSingleLinkedList;

import java.util.Stack;

/**
 * @Author shenlp
 * @Date 2023/10/25 16:53
 * @Description:反向链表
 **/
public class SingleLinkedListDemo2 {

    //初始化头结点
    Node head = new Node(-99);

    /**
     *
     * @param node
     */
    public void add(Node node){
        Node current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = node;
    }

    /**
     * 获取列表长度
     * @return
     */
    public int size(){
        Node current = this.head;
        int count = 0;
        while(current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * 展示所有结点
     */
    public void show(){
        Node current = this.head;
        while(current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
    //------------核心方法

    /**
     * 寻找链表倒数第k个结点
     * @param list
     * @param index
     * @return
     */
    public Node findLastIndexNode(SingleLinkedListDemo2 list,int index){
        //首结点
        Node head = list.head;
        if(index < 0 || head.next == null || index > size()){
            return null;
        }
        Node current = head.next;
        for(int i = 0 ; i <size() - index;i++){
            current = current.next;
        }

        return current;
    }

    /**
     * 将链表反转
     * @param sll 待反转的链表
     * 头插法
     * 第一次进入：newHead = 0,head = 1(1->2->3->4->5);
     *
     * 第二次进入：newHead = 0(0->1),head = 2(2->3->4->5);
     *
     * 第三次进入：newHead = 0(0->2->1),head = 3(3->4->5);
     *
     * 第四次进入：newHead = 0(0->3->2->1),head = 4(4->5);
     *
     * 第五次进入：newHead = 0(0->4->3->2->1),head = 5(5->null);
     */
    public void reverset (SingleLinkedListDemo2 sll){
        //旧链表头节点
        Node head = sll.head;
        if(head.next ==null || head.next.next == null){
            //当前链表为空，或者只有一个结点，直接返回
            return;
        }
        //创建一个新链表
        SingleLinkedListDemo2 newList = new SingleLinkedListDemo2();
        //新链表首节点
        Node headTemp = newList.head;
        //用于存储旧链表的引用，方便遍历旧链表
        Node temp = null;
        //辅助遍历旧链表
        Node current = head.next;
        while(current != null)
        {
            //用于接着遍历下一个节点
            temp = current.next;
            //指向新创建的头结点的后面的结点
            current.next = headTemp.next;
            //指向新创建的头结点的后面的结点
            headTemp.next = current;
            current = temp;
        }
        head.next = headTemp.next;
    }


    /**
     * 反向打印链表
     * @param sll
     */
    public void reversetPrint(SingleLinkedListDemo2 sll){
        Node head = sll.head;
        if(head.next == null){
            return;
        }
        //1.使用findLastIndexNode方法
        //2.使用reverset方法
        //3.使用栈方法
        Stack<Node> stack = new Stack<>();
        Node current = head.next;
        while(current != null){
            stack.push(current);
            current = current.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的链表，合并后仍然有序（默认是从小到大）
     * @param sll1
     * @param sll2
     * @return
     */
    public SingleLinkedListDemo2 combine(SingleLinkedListDemo2 sll1,SingleLinkedListDemo2 sll2){
        Node head1 = sll1.head.next;//为了遍历SingleLinkedListDemo2
        Node head2 = sll2.head.next;
        if(head1 == null || head2 == null){
            //只要有一个空就直接返回
            return  head1 !=null ? sll1 :sll2;
        }
        SingleLinkedListDemo2 sll = new SingleLinkedListDemo2();
        Node temp = sll.head;//用来给sll链表添加结点的
        while(head1 != null && head2 != null){
            if(head1.n < head2.n){
                //链表1的结点是当前最小的结点
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }else{
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        //会输入链表中有一个链表遍历完，则另一个链表直接插入尾部
        if(head1 != null && head2 ==null){
            temp.next = head1;
        }
        if(head2 != null && head1 ==null){
            temp.next = head2;
        }
        return sll;
    }

}

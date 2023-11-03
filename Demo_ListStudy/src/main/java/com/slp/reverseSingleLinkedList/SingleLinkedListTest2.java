package com.slp.reverseSingleLinkedList;

import com.slp.reverseSingleLinkedList.Node;
import com.slp.reverseSingleLinkedList.SingleLinkedListDemo2;

/**
 * @Author shenlp
 * @Date 2023/10/30 9:50
 * @Description:
 **/
public class SingleLinkedListTest2 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        SingleLinkedListDemo2 sll = new SingleLinkedListDemo2();
        sll.add(node1);
        sll.add(node2);
        sll.add(node3);
        System.out.println("链表原始状态：");
        sll.show();

        System.out.println("------------------------");
        //测试1：测试获取链表倒数第k个结点
        Node t = sll.findLastIndexNode(sll, 1);
        System.out.println(t);
//        System.out.println(sll.findLastIndexNode(sll,1));
//        System.out.println(sll.findLastIndexNode(sll,2));
//        System.out.println(sll.findLastIndexNode(sll,3));

        System.out.println("-------------------------");
        //测试2：测试将链表反转
        sll.reverset(sll);
        System.out.println("反转后的链表：");
        sll.show();

        System.out.println("-------------------------");
        //测试3：从头到位打印链表
        System.out.println("反向打印链表：");
        sll.reversetPrint(sll);

        System.out.println("-------------------------");
        //测试4：将两个有序链表合并，合并后仍然有序
        SingleLinkedListDemo2 list1 = new SingleLinkedListDemo2();
        SingleLinkedListDemo2 list2 = new SingleLinkedListDemo2();
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        list1.add(node4);
        list1.add(node7);
        list1.add(node8);
        list1.add(node10);
        list1.add(node11);
        System.out.println("链表1：");
        list1.show();

        System.out.println("链表2：");
        list2.add(node5);
        list2.add(node6);
        list2.add(node9);
        list2.show();

        SingleLinkedListDemo2 list = new SingleLinkedListDemo2();
        list = list.combine(list1, list2);

        System.out.println("合并后的链表：");
        list.show();
    }
}

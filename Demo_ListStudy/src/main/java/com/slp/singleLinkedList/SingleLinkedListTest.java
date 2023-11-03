package com.slp.singleLinkedList;

import java.util.List;
import java.util.Scanner;

/**
 * @Author shenlp
 * @Date 2023/10/24 16:17
 * @Description:测试单链表
 **/
public class SingleLinkedListTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedListDemo1 sll = new SingleLinkedListDemo1();
        while (true){
            System.out.println("-------------------单向链表操作界面-----------------");
            System.out.println("请输入操作指令：");
            System.out.println("0 : 退出程序");
            System.out.println("1 : 在链尾添加结点");
            System.out.println("2 : 按id从小到大的顺序添加结点");
            System.out.println("3 : 根据id获取结点");
            System.out.println("4 : 根据id删除结点");
            System.out.println("5 : 获取链表中元素的个数");
            System.out.println("6 : 展示链表中所有的元素");
            System.out.println("7 : 根据id修改结点");
            System.out.println("8 : 清空链表");
            //用于接收用户输入
            int id;
            String name="";
            String alias="";
            Student student = null;
            switch(sc.next()) {
                case "0": //退出程序
                    System.out.println("正在退出程序~~~");
                    break ;
                case "1": //在链尾添加结点
                    System.out.println("请按照 id name alias 的格式输入要添加的元素：");
                    id = sc.nextInt();
                    name = sc.next();
                    alias = sc.next();
                    student = new Student(id,name,alias);
                    if(sll.add(student)) System.out.println("结点："+student+"添加成功！");
                    break;
                case "2"://按id从小到大的顺序添加结点
                    System.out.println("请按照 id name alias 的格式输入要添加的元素：");
                    id = sc.nextInt();
                    name = sc.next();
                    alias = sc.next();
                    student = new Student(id,name,alias);
                    if(sll.addById(student)) System.out.println("结点："+student+"添加成功！");
                    break;
                case "3"://根据id获取结点
                    System.out.println("请输入要获取结点的id号：");
                    id = sc.nextInt();
                    try {
                        student  = sll.get(id);
                        System.out.println(id+"号结点为："+student);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4"://根据id删除结点
                    System.out.println("请输入要删除结点的id号：");
                    id = sc.nextInt();
                    try {
                        if(sll.remove(id)) System.out.println("结点删除成功！");
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5"://获取链表中结点的个数（不包括头节点）
                    System.out.println("链表中的结点个数为："+sll.size());
                    break;
                case "6"://展示链表中所有的结点（不包括头节点）
                    sll.show();
                    break;
                case "7"://根据id修改结点
                    System.out.println("请按照 id name alias 的格式输入要修改的元素：");
                    student = new Student(sc.nextInt(),sc.next(),sc.next());
                    try {
                        if(sll.update(student)) System.out.println("修改成功");
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "8"://清空链表
                    if(sll.clear()) System.out.println("链表已成功清空！");
                    break;
                default:
                    System.out.println("请输入有效指令！");
                    break;
            }
            System.out.println("程序已退出");
        }
    }
}

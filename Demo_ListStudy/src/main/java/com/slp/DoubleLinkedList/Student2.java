package com.slp.DoubleLinkedList;

/**
 * @Author shenlp
 * @Date 2023/10/24 16:28
 * @Description:节点类
 **/
public class Student2 {
    //数据域
    public int id;
    public String name;
    public String alias;
    //引用域
    //指向下一个结点
    public Student2 next;
    //指向上一个结点
    public Student2 pre;


    public Student2(int id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}

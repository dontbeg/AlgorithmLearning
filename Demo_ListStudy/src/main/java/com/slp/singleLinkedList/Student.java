package com.slp.singleLinkedList;

/**
 * @Author shenlp
 * @Date 2023/10/24 16:28
 * @Description:节点类
 **/
public class Student {
    //数据域
    public int id;
    public String name;
    public String alias;
    //引用域

    public Student next;

    public Student(int id, String name, String alias) {
        this.id = id;
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}

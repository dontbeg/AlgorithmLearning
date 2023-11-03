package com.slp.DoubleLinkedList;


import com.slp.singleLinkedList.Student;

/**
 * @Author shenlp
 * @Date 2023/10/30 10:49
 * @Description:
 **/
public class DoubleLinkedListDemo1 {
    //初始化头节点
    Student2 head = new Student2(-99,"","");

    /**
     * 判单链表是否为空,true代表是空
     */
    public boolean isEmpty(){
        //指针
        Student2 temp = head.next;
        if(temp != null){
            return false;
        }
        return true;
    }

    /**
     * 在列尾添加数据
     * @param student 添加的node节点元素
     * @return true代表添加成功
     */
    public boolean add(Student2 student){
        //从头部节点开始
        Student2 temp = head;
        //开始向下遍历，一直遍历到next没有指向
        while(temp.next != null ){
            temp  = temp.next;
        }
        //已经找到，将指针指向新的node
        temp.next = student;
        //形成双向链表
        student.pre = temp;
        return true;
    }


    /**
     * 按照id从小到大的顺序添加节点
     * @param student 待添加的
     * @return true 代表添加成功
     */
    public boolean addById(Student2 student){
        Student2 temp = head;
        boolean flag = true;//用于判断链表是加在尾结点，还是加在结点之间
        while(temp.next != null){
            if(student.id < temp.next.id){//添加的节点id小于指针id的时候，代表添加在节点之间
                flag = false;
                break;
            }
            //指针进行指向下一个
            temp = temp.next;
        }
        if(flag){
            //如果是添加在尾部
            temp.next = student;
            student.pre = temp;
        }else{
            //如果添加在两个结点之间，需要改变前后结点的指向
            student.next = temp.next;
            temp.next.pre = student;
            //形成双向链表
            temp.next = student;
            student.pre = temp;
        }
        return true;
    }

    /**
     * 根据id获取结点
     * @param id
     * @return
     */
    public Student2 get(int id){
        if(isEmpty()){
            throw new RuntimeException("该链表为空");
        }
        Student2 temp = head.next;//指针
        boolean flag = false;//判断是否找到节点
        while(temp != null){
            if(temp.id == id){
                //找到id对于的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //找到id对应的节点
            return temp;
        }else{
            throw new RuntimeException("查询的id不存在");
        }
    }

    /**
     * 根据id删除对应的节点
     * @param id
     * @return
     */
    public boolean remove(int id) {
        if(isEmpty()){
            throw new RuntimeException("该链表为空");
        }
        //头部节点
        Student2 temp = head.next;
        boolean flag = false;//true代表删除成功
        while(temp != null){
            if(temp.id == id ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){

//            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;//删除前一个结点
            //避免后一个结点为空
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

            return true;
        }else{
            throw new RuntimeException("查询的id不存在");
        }
    }

    /**
     * 获取链表中节点个数（不包括头部节点）
     * @return
     */
    public int size(){

        Student2 temp = head;
        //计数器
        int count = 0;
        //虽然遍历首节点，但是未遍历尾节点，故总量不变
        while (temp.next != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 展示所有的节点（不包括首节点）
     */
    public void show(){
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }

        //不展示首节点
        Student2 temp = head;
        while(temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 根据student的id去更新链表
     * @param student
     * @return
     */
    public boolean update(Student2 student){
        if(isEmpty()){
            throw new RuntimeException("链表为空！");
        }
        //首节点
        Student2 temp = head.next;
        //判断是否可以更新
        boolean flag = false;
        while(temp != null){
            if(student.id == temp.id){
                flag = true;
                //改变指标下一个节点，前后引用
                //前者双向
                temp.pre.next = student;
                student.pre = temp.pre;
                //后者双向(可能存在向右的指向为空值)
                student.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = student;
                }

//                temp.next = student;
//                student.next = temp.next.next;
                break;
            }else{
                temp = temp.next;
            }
        }
        if(flag) {
            //如果修改成功
            return true;
        }else {
            //如果链表中没有找到待删除的结点
            throw new RuntimeException("链表中不存在该结点");
        }
    }
    /**
     * 清空链表
     * @return
     */
    public boolean clear(){
        /**
         * 1.方法一：首节点，直接指向null，但是会导致剩下的节点还是连接在一起，无法被jvm回收，因为它仍然还有引用，造成
         * 内存使用过高
         */
        //2.方法二：将所有节点引用指向null，会耗时
        Student2 temp = head;
        while(temp.next != null){
            //重要的一点在于，要从后向前遍历，否则从前向后，之前链表的引用域变为空，无法遍历后续节点
            for (int i = size(); i > 1 ;i--){
                temp = temp.next;
            }
            temp.next = null;
        }
        return true;
    }

}

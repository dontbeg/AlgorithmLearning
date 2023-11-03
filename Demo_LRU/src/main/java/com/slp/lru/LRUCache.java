package com.slp.lru;

import java.util.HashMap;

/**
 * @Author shenlp
 * @Date 2023/10/31 17:00
 * @Description:LRU队列实现
 * 1.需要有一个HashMap完成key->Node的映射
 * 2.需要有一个DoubleList来存放Node节点
 * 3.有容量上限cap
 * 4.使用私有的delete()/removeLast()/makeFirst()/addFirst()来辅助put()和get()方法，避免直接操作node
 * 5.有put()/get()/size()方法
 **/
public class LRUCache {
    //key-node的映射
    private HashMap<Integer, Node> map;

    //双向链表作为缓存队列
    private DoubleList cache;

    //最大容量
    private int cap;

    public LRUCache(int cap) {
        map = new HashMap<Integer, Node>();
        cache = new DoubleList();
        this.cap = cap;
    }

    /**
     * 删除某个key对于的键值对
     * @param key
     */
    public void delete(int key){
        //获取相应key对于的节点
        Node node = map.get(key);
        //双向链表删除节点
        cache.remove(node);
        //map中移除
        map.remove(key);
    }

    /**
     * 删除缓存队列中最后一个节点，也就是许久未使用节点
     */
    public void removeLast(){
        //从链表中删除节点
        Node node = cache.removeLast();
        //从删除节点获取key
        map.remove(node.key);
        //此处就是为啥node加key，通过key来删除map
    }

    /**
     * 将某个节点提到首部,也就是变成最近使用的节点
     * @param key
     */
    public void makeFirst(int key){
        Node node = map.get(key);
        //先移除旧节点，再新增新节点
        cache.remove(node);
        cache.addFrist(node);
    }

    /**
     * 添加一个键值对到队首，也就是最近使用位置
     * @param key
     * @param val
     */
    public void addFirst(int key,int val){
        Node node = new Node(key, val);
        cache.addFrist(node);
        map.put(key,node);
    }

    /**
     * 在插入过程进行判断是直接新增还是删除
     * @param key
     * @param val
     */
    public void put(int key,int val){
        if(map.containsKey(key)){//说明存在key，需要更新操作
            //先删除
            delete(key);
            //再插入首部
            addFirst(key,val);
            return;
        }
        //如果新增
        //当达到容量上限时
        if(cache.size() == cap){
            //删除最后一个
            removeLast();
            //新增首部
            //添加map
//            map.put(key,map.get(key));
        }
        addFirst(key,val);
    }

    /**
     * 暴露出来的get()方法,根据key获取到val,若不存在,则返回-1(假定val都为正整数)
     * @param key
     */
    public int get(int key){
        if (!map.containsKey(key)){
            //key不存在
            return -1;
        }
        //将该key移动到队首,也就是最近使用的第一个
        makeFirst(key);
        //返回值　
        return map.get(key).value;
    }
    /**
     * 暴露出来的size（）方法，返回当前大小
     * @return
     */
    public int size(){
        return cache.size();
    }

    /**
     * 打印缓存列表
     */
    public void print(){
        cache.print();
    }
}

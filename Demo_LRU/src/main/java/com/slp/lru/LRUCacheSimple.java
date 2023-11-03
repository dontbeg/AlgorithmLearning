package com.slp.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @Author shenlp
 * @Date 2023/11/2 14:45
 * @Description:
 **/
public class LRUCacheSimple {
    private int cap;

    private LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();

    public LRUCacheSimple(int cap) {
        this.cap = cap;
    }

    /**
     * 将某个键改成最近使用的
     * @param key
     */
    public void makeRecently(int key){
        //先获取值
        Integer value = cache.get(key);
        //删除该键
        cache.remove(key);
        //重新插入
        cache.put(key,value);
    }

    /**
     * 插入key，val
     * @param key
     * @param value
     */
    public void put(Integer key,Integer value){
        if(cache.containsKey(key)){
            //如果存在就覆盖
            cache.put(key,value);
            //在把他变成最近未使用
            makeRecently(key);
            return;
        }
        if(cap <= cache.size()){
            //当满了以后，删除第一个节点
            Integer frist = cache.keySet().iterator().next();
            //删除该节点
            cache.remove(frist);
        }
        //将新的key,value插入
        cache.put(key, value);
    }
    /**
     * 根据key获取value(假定value都是正整数)
     * @param key
     * @return value(-1表示不存在)
     */
    public int get(int key){
        if (!cache.containsKey(key)){
            return -1;
        }
        //将该key变成最近使用的
        makeRecently(key);
        return cache.get(key);
    }
    /**
     * 打印该缓存
     */
    public void print(){
        Iterator<Integer> iterator = cache.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            System.out.print(key+"->"+ cache.get(key)+" ");
        }
        System.out.println();
    }
}

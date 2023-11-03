package com.slp.lru;

import java.util.Scanner;

/**
 * @Author shenlp
 * @Date 2023/11/1 11:24
 * @Description:
 **/
public class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        Scanner sc = new Scanner(System.in);
        int key,val;
        while(true){
            System.out.println("请输入插入的key和val(以空格隔开,输入-1则结束)");
            key = sc.nextInt();
            if (key == -1) break;
            val = sc.nextInt();
            lruCache.put(key,val);
            lruCache.print();
        }
        while(true){
            System.out.println("请输入需要获取的key(输入-1则结束)");
            key = sc.nextInt();
            if (key == -1) break;
            System.out.println("key->val: "+key+"->"+lruCache.get(key));
            lruCache.print();
        }
    }
}

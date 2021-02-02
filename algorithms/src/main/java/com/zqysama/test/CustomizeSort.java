package com.zqysama.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomizeSort {

    void testCustomizeSort() {
        List<String> orderNos = new ArrayList(){{
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
        }};
        orderNos.remove("测试1");
        orderNos.remove("测试2");
        orderNos.remove("five");


        int i = 1;
        // 指定需要最终排序的顺序
        HashMap<String, Integer> keyMap = new HashMap<>();
        for (String order : orderNos) {
            keyMap.put(order,i++);
        }

        // 需要做排序的字符串列表
        ArrayList<Order> updateList = new ArrayList() {{
            add(new Order("测试1","5"));
            add(new Order("测试2","5"));
            add(new Order("five","5"));
            add(new Order("one","1"));
            add(new Order("three","3-1"));
            add(new Order("three","3-3"));
            add(new Order("three","3-2"));
            add(new Order("two","2"));
            add(new Order("four","4"));
        }};

        System.out.println("排序前：");
        for (Order order : updateList) {
            System.out.println(order.toString());
        }



        // 进行排序操作
        updateList.sort((o1, o2) -> {
            // 处理不存在指定排序列表中的字符串
            if (keyMap.get(o1.getOrderNo()) == null || keyMap.get(o2.getOrderNo()) == null) {
                return 1;
            }
            return keyMap.get(o1.getOrderNo()).compareTo(keyMap.get(o2.getOrderNo()));
        });



        System.out.println("排序后：");
        for (Order order : updateList) {
            System.out.println(order.toString());
        }

    }
}

package com.security.tedu.service;

import com.security.tedu.entity.Kvs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
//        public static void main(String[] args) {

//            List<Kvs<String>> kvsList = new ArrayList<>();
//            kvsList.add(new Kvs<>("A0001", "Answer"));
//            kvsList.add(new Kvs<>("A0001", "AnswerAIL"));
//            kvsList.add(new Kvs<>("A0001", "AI"));
//            kvsList.add(new Kvs<>("A0002", "Iris"));
//            kvsList.add( new Kvs<>("A0002", "IrisA"));
//            kvsList.add(new Kvs<>("A0003", "Allen"));
//            kvsList.add(new Kvs<>("A004", "James"));
//            kvsList.add(new Kvs<>("A005", "Kak"));
//            kvsList.add(new Kvs<>("A005", "KaKa"));
//            // 对 key 进行统计个数
//            Map<String, Long> map1 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.counting()));
//            System.out.println("map1=" + JSON.toJSONString(map1));
//            System.out.println();
//
//            // 根据 key 对集合进行分组-1
//            Map<String, List<Kvs>> map2_1 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.toList()));
//            System.out.println("map2_1=" + JSON.toJSONString(map2_1));
//            System.out.println();
//
//            // 根据 key 对集合进行分组-2
//            Map<String, List<Kvs>> map2_2 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey));
//            System.out.println("map2_2=" + JSON.toJSONString(map2_2));
//            System.out.println();
//
//            // 根据 key 对集合进行分组, 并且 value 的集合为指定属性集合而不是对象
//            Map<String, List<String>> map3 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.mapping(Kvs::getValue, Collectors.toList())));
//            System.out.println("map3=" + JSON.toJSONString(map3));
//            System.out.println();
//            // List<Kvs> -> Map<String, List<Order>>
////        Map<String, List<Order>> map3 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.mapping(e -> new Order(e.getNo(), e.getAmt(), Collectors.toList())));
//
//            // 根据 key 进行分组并且将指定属性值进行拼接作为哈希表的 value 值
//            Map<String, String> map4 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.mapping(Kvs::getValue, Collectors.joining("#"))));
//            System.out.println("map4=" + JSON.toJSONString(map4));
//            System.out.println();
//
//            // 根据 key 进行分组并根据 指定属性进行比较取最大元素
//            Map<String, Optional<Kvs<String>>> map5 = kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.maxBy(Comparator.comparing(Kvs::getValue))));
//            System.out.println("map5=" + JSON.toJSONString(map5));
//            System.out.println();
//
//            // partitioningBy 会根据 传入的 表达式进行判断, 将集合分为 true 和 false 两个列表
//            Map<Boolean, List<Kvs>> map6 = kvsList.stream().collect(Collectors.partitioningBy(kvs -> "A0001".equals(kvs.getKey())));
//            System.out.println("map6=" + JSON.toJSONString(map6));
//            System.out.println();
//
//            // 遍历结果集
//            kvsList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.toList())).forEach((k, v) -> {
//                System.out.println(MessageFormat.format("key={0}, value={1}", k, v));
//            });
//
//
//            List<Kvs<Integer>> numList = Lists.newArrayList(
//                    new Kvs<>("A001", 1),new Kvs<>("A001", 2),new Kvs<>("A001", 3),
//                    new Kvs<>("A002", 5),new Kvs<>("A002", 3),new Kvs<>("A003", 7)
//            );
//            System.out.println();
//
//            // 根据 key 进行分组并且根据 指定数据进行统计
//            Map<String, Integer> num1 = numList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.summingInt(Kvs::getValue)));
//            System.out.println("num1=" + JSON.toJSON(num1));
//            System.out.println();
//
//            // summarizingInt 用来同时计算 average、min、max、count、sum
//            Map<String, IntSummaryStatistics> num2 = numList.stream().collect(Collectors.groupingBy(Kvs::getKey, Collectors.summarizingInt(Kvs::getValue)));
//            System.out.println("num2=" + JSON.toJSON(num2));
//            System.out.println();
//
//            // 集合实体转 实体中某一字段集合
//            List<String> keys = kvsList.stream().map(Kvs::getKey).collect(Collectors.toList());
//        }
}

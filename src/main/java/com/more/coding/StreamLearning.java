package com.more.coding;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author zsl
 * @date 2022/12/4
 * @apiNote
 */
public class StreamLearning {
    public static void main(String[] args) {
        System.out.println(calculateNum((left, right) -> left - right));

        printNum(value -> value % 2 == 0
        );

        System.out.println(typeConvert(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        }));

        constructStream();
    }

    public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a,b);
    }

    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i :  arr) {
            if (predicate.test(i))
                System.out.println(i);
        }
    }

    public static <R> R typeConvert(Function<String,R> function){
        String str = "1234";
        R result = function.apply(str);
        return result;
    }

    // 创建流对象
    public static void constructStream(){
        ArrayList<Integer> list = new ArrayList<>();
        list.stream();
        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr);

        Stream<int[]> arr1 = Stream.of(arr);

        Integer[] arr2 = {1,2,3};
        Stream<Integer> arr21 = Stream.of(arr2);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("nanke",24);
        map.put("conan",17);
        map.put("lan",17);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue()>18)
                .forEach(stringIntegerEntry
                        -> System.out.println(stringIntegerEntry.getKey()
                        + "==" + stringIntegerEntry.getValue()));


    }
}

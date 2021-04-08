package com.zqysama.algorithmsList;

import org.springframework.expression.Operation;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/tbrain_wf?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true";
        String[] split = url.split(":|/");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }


    }
}

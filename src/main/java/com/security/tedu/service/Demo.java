package com.security.tedu.service;

public class Demo {
    static int i=1;
    public static void main(String[] args) {
        int sum = 0;
        show(sum);
    }

    private static void show(int sum) {
        sum=sum+i; //业务代码1
        //递归头
        if(i==100){
            System.out.println(sum);
            return;
        }
        i++;   //业务代码2
        show(sum); //递归体
    }
}

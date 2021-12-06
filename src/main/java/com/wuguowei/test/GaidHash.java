package com.wuguowei.test;

import java.util.Random;

public class GaidHash {

    public static void main(String[] args) {
        getPartitionId("001adeef-10c7-41e9-bad6-3ae288247e36");
        String aaa = null;
        getPartitionId(aaa);
    }

    private static void getPartitionId(String in){
        int length = 30;
        /*
        System.out.println("input is: " + in);
        int res = in.hashCode() & Integer.MAX_VALUE % length;
        System.out.println("partition id is:" + res);

         */
        int partitionId = new Random().nextInt(length);
        try {
            partitionId = in.hashCode() & Integer.MAX_VALUE % length;
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        System.out.println("partitionId is:" + partitionId);
    }

}

package com.wuguowei.test;

public class TestString {
    private static String jobName;
    private final String clusterName;

    public TestString(String jobName){
        this.jobName = jobName;
        this.clusterName = "hello";
    }

    public void updateCnt(){
        System.out.println("jobName is " + jobName);
    }

}

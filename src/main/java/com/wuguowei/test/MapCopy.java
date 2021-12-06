package com.wuguowei.test;

import java.util.HashMap;
import java.util.Map;

public class MapCopy {
    public static class EventCnt {
        public Long cnt = 0L;

        public EventCnt(Long cnt) {
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "event cnt is:" + cnt;
        }
    }

    public static void main(String[] args) {
        /*
        Map<String, String> test = new HashMap<>();
        test.put("1", "4");
        test.put("2", "5");
        HashMap<String, String> tmp = new HashMap<>();
        test.forEach(tmp::put);
        tmp.forEach((k, v) -> {
            test.remove("2");
        });
        System.out.println("tmp:" + tmp);
        System.out.println("test:" + test);
         */
        Map<String, EventCnt> test = new HashMap<>();
        test.put("view", new EventCnt(3L));
        test.put("click", new EventCnt(400L));
//        test.forEach((k, v) -> {
////            eventCnt eventCnt = test.get(k);
////            eventCnt.cnt++;
//            v.cnt++;
//        });
        EventCnt eventCnt = test.get("view");
        eventCnt.cnt = 10000L;

        System.out.println(test);
    }
}

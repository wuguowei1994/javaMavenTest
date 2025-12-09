package com.wuguowei.test.druid.offset.bugfix;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        OffsetTracker tracker = new OffsetTracker();

        // 模拟：“后台线程”每秒更新 offset
        Thread updater = new Thread(() -> {
            long end = 100;
            long current = 90;
            try {
                while (true) {
                    end += 10;
                    current += 9;
                    tracker.update(end, current);

                    System.out.println("[UPDATE] " + tracker.getSnapshot());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) {}
        });

        // 模拟：“客户端线程”频繁读取 lag
        Thread reader = new Thread(() -> {
            try {
                while (true) {
                    long lag = tracker.getLag();
                    System.out.println("    [READ] lag = " + lag);
                    Thread.sleep(300);
                }
            } catch (InterruptedException ignored) {}
        });

        updater.start();
        reader.start();

        updater.join();
        reader.join();
    }
}

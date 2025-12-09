package com.wuguowei.test.druid.offset.bugfix;

import java.util.concurrent.atomic.AtomicReference;

public class OffsetTracker {

    private final AtomicReference<OffsetPair> ref =
            new AtomicReference<>(new OffsetPair(0, 0));

    // 原子更新整个 OffsetPair
    public void update(long newEnd, long newCurrent) {
        ref.set(new OffsetPair(newEnd, newCurrent));
    }

    // 读取 snapshot
    public OffsetPair getSnapshot() {
        return ref.get();
    }

    // 获取一致的 lag
    public long getLag() {
        OffsetPair p = ref.get();
        return p.end - p.current;
    }
}

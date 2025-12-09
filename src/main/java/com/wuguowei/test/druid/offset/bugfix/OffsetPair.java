package com.wuguowei.test.druid.offset.bugfix;

public final class OffsetPair {
    public final long end;
    public final long current;

    public OffsetPair(long end, long current) {
        this.end = end;
        this.current = current;
    }

    @Override
    public String toString() {
        return "OffsetPair{end=" + end + ", current=" + current + "}";
    }
}

package com.wuguowei.test;

public class TagIdHourTTL {
    // 广告位id(主键)
    public String tagId;
    // 过期时间(小时)
    public int cacheHour;
    // 调整步长
    public int stepHour;
    // 上次更新时间戳
    public long updateTime;
    // 当前小时处理的数据总量
    public long sumCnt;
    // 当前小时处理的数据中, 低于50%过期时间的量
    public long lowCnt;
    // 当低于50%过期时间的数据量达到多少比例时, 减少步长, 百分比值
    public int lowJumpRate;
    // 当前小时关联成功的数据量
    public long joinedCnt;
    // 当前小时关联失败的数据量
    public long unjoinedCnt;
    // 当关联成功率低于这个值时, 增加步长, 百分比值
    public int lowJoinedJumpRate;
    // 任务名称
    public String jobName;

    public TagIdHourTTL() {
    }

    public TagIdHourTTL(String tagId, int cacheHour, int stepHour, long updateTime, long sumCnt, long lowCnt, int lowJumpRate, long joinedCnt, long unjoinedCnt, int lowJoinedJumpRate, String jobName) {
        this.tagId = tagId;
        this.cacheHour = cacheHour;
        this.stepHour = stepHour;
        this.updateTime = updateTime;
        this.sumCnt = sumCnt;
        this.lowCnt = lowCnt;
        this.lowJumpRate = lowJumpRate;
        this.joinedCnt = joinedCnt;
        this.unjoinedCnt = unjoinedCnt;
        this.lowJoinedJumpRate = lowJoinedJumpRate;
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "TagIdHourTTL{" +
                "tagId='" + tagId + '\'' +
                ", cacheHour=" + cacheHour +
                ", stepHour=" + stepHour +
                ", updateTime=" + updateTime +
                ", sumCnt=" + sumCnt +
                ", lowCnt=" + lowCnt +
                ", lowJumpRate=" + lowJumpRate +
                ", joinedCnt=" + joinedCnt +
                ", unjoinedCnt=" + unjoinedCnt +
                ", lowJoinedJumpRate=" + lowJoinedJumpRate +
                ", jobName='" + jobName + '\'' +
                '}';
    }

    public enum CacheSize {
        SMALL, MID, BIG ;
    }

    public static TagIdHourTTL createNewCache(String tagId, CacheSize cacheSize, String jobName) {
        switch (cacheSize) {
            case MID:
                return new TagIdHourTTL(tagId, 72, 6,
                        System.currentTimeMillis(), 0, 0, 98, 0, 0,
                        98, jobName);
            case BIG:
                return new TagIdHourTTL(tagId, 120, 10,
                        System.currentTimeMillis(), 0, 0, 98, 0, 0,
                        98, jobName);
            default:
                return new TagIdHourTTL(tagId, 6, 1,
                        System.currentTimeMillis(), 0, 0, 98, 0, 0,
                        98, jobName);
        }
    }
}

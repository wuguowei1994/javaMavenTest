package com.wuguowei.test.column;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Table2ColumnMap {
    public static Map<String, String> getColumnMap(){
        Map<String, String> fieldsMap = extractFields();
        fieldsMap.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("unique values:");
        Set<String> uniqueValues = new HashSet<>(fieldsMap.values());
        uniqueValues.forEach(System.out::println);

        return fieldsMap;
    }

    private static Map<String, String> extractFields() {
        Map<String, String> fieldsMap = new LinkedHashMap<>();

        String[] lines = Table2ColumnMap.ddl.split("\n");
        for (String line : lines) {
            String[] parts = line.split("\\s+");

            if (parts.length >= 2) {
                String fieldName = parts[0].replace("`", "");
                String fieldType = parts[1];

                fieldsMap.put(fieldName, fieldType.replaceAll(",", ""));
            }
        }

        return fieldsMap;
    }

    private static final String ddl = "`producerVersion`     LowCardinality(String) DEFAULT '',\n" +
            "`version`       LowCardinality(String) DEFAULT '',\n" +
            "`customerId`      Int32,\n" +
            "`clientId`       String DEFAULT '',\n" +
            "`sessionId`      String DEFAULT '',\n" +
            "`sessionStartTimeMs`    DateTime64(3),\n" +
            "`inSession`      UInt8,\n" +
            "`pageId`       String,\n" +
            "`pageStartTimeMs`     DateTime64(3),\n" +
            "`platform`       LowCardinality(String),\n" +
            "`appName`       LowCardinality(String),\n" +
            "`appBuild`       String,\n" +
            "`appVersion`      LowCardinality(String),\n" +
            "`appType`       LowCardinality(String),\n" +
            "`sensorVersion`     LowCardinality(String),\n" +
            "`referrerHost`      String DEFAULT '',\n" +
            "`host`        String DEFAULT '',\n" +
            "`path`        String DEFAULT '',\n" +
            "`query`       String DEFAULT '',\n" +
            "`referrer`       String DEFAULT '',\n" +
            "`title`       String DEFAULT '' CODEC(ZSTD(10)),\n" +
            "`url`        String DEFAULT '' CODEC(ZSTD(10)),\n" +
            "`userAgent`      String DEFAULT '',\n" +
            "`deviceName`      String DEFAULT '',\n" +
            "`deviceCategory`     LowCardinality(String) DEFAULT '',\n" +
            "`deviceHardwareType`    LowCardinality(String) DEFAULT '',\n" +
            "`deviceManufacturer`    LowCardinality(String) DEFAULT '',\n" +
            "`deviceMarketingName`    LowCardinality(String) DEFAULT '',\n" +
            "`deviceOperatingSystem`   LowCardinality(String) DEFAULT '',\n" +
            "`deviceOperatingSystemVersion`  LowCardinality(String) DEFAULT '',\n" +
            "`deviceOperatingSystemFamily`  LowCardinality(String) DEFAULT '',\n" +
            "`deviceModel`      LowCardinality(String) DEFAULT '',\n" +
            "`browserName`      LowCardinality(String) DEFAULT '',\n" +
            "`browserVersion`     LowCardinality(String) DEFAULT '',\n" +
            "`playerFrameworkName`    LowCardinality(String) DEFAULT '',\n" +
            "`playerFrameworkVersion`   LowCardinality(String) DEFAULT '',\n" +
            "`country`          Int64 DEFAULT 0,\n" +
            "`state`          Int64 DEFAULT 0,\n" +
            "`city`           Int64 DEFAULT 0,\n" +
            "`isp`        Int32 DEFAULT 0,\n" +
            "`asn`        Int32 DEFAULT 0,\n" +
            "`postalCode`      String DEFAULT '',\n" +
            "`timezoneOffsetMins`    LowCardinality(String) DEFAULT '',\n" +
            "`ipV4`                          String DEFAULT '',\n" +
            "`ipV6`                          String DEFAULT '',\n" +
            "`userId`       String DEFAULT '',\n" +
            "`domain`       String DEFAULT '',\n" +
            "`connType`             LowCardinality(String) DEFAULT '',\n" +
            "`netSpeed`       LowCardinality(String) DEFAULT '',\n" +
            "`customMetadata`     JSON,\n" +
            "`queryTimestampMs`     DateTime64(3),\n" +
            "`watermarkMs`      DateTime64(3),\n" +
            "`partitionId`      Int32,\n" +
            "`lifeSessionAppCrashCount`   UInt32,\n" +
            "`lifeSessionSessionDurationMs`  UInt64,\n" +
            "`lifeSessionPageLoadDurationMs` UInt64,\n" +
            "`lifeSessionUserActiveTimeMs`            UInt64,\n" +
            "`lifeSessionAppStartupDurationMs`           UInt64,\n" +
            "`lifeSessionAppStartupCount`                    UInt32,\n" +
            "`lifeSessionNetworkRequestDurationMs`           UInt32,\n" +
            "`lifeSessionNetworkRequestCount`                UInt32,\n" +
            "`lifeSessionNetworkRequestSuccessDurationMs`    UInt32,\n" +
            "`lifeSessionNetworkRequestSuccessCount`         UInt32,    \n" +
            "`lifeSessionEventCount`             UInt32,\n" +
            "`lifeSessionUserEventCount`            UInt32,\n" +
            "`lifeSessionErrorEventCount`            UInt32,\n" +
            "`lifeSessionPageLoadSuccessCount`               UInt32,\n" +
            "`lifeSessionPageLoadAttemptCount`               UInt32,\n" +
            "`lifeSessionEndStatus`              UInt8,\n" +
            "`lifeSessionConvivaExtraDurationMsMetrics`              JSON,\n" +
            "`lifeSessionConvivaExtraDurationCountMetrics`           JSON,\n" +
            "`lifeSessionConvivaExtraCountMetrics`                   JSON,\n" +
            "`lifeSessionConvivaExtraConversionSuccessCountMetrics`  JSON,\n" +
            "`lifeSessionConvivaExtraConversionFailureCountMetrics`  JSON,\n" +
            "`lifeSessionCustomDurationMsMetrics`                  JSON,\n" +
            "`lifeSessionCustomDurationCountMetrics`                 JSON,\n" +
            "`lifeSessionCustomConversionSuccessCountMetrics`        JSON,\n" +
            "`lifeSessionCustomConversionFailureCountMetrics`        JSON,\n" +
            "`lifeSessionCustomConversionHasAttemptMetrics`          JSON,\n" +
            "`lifeSessionCustomConversionHasSuccessMetrics`          JSON,\n" +
            "`lifeSessionEventName`                                  Array(String),\n" +
            "`lifeSessionEventCategory`                              Array(String),\n" +
            "`lifePageAppCrashCount`                     UInt32,\n" +
            "`lifePagePageLoadDurationMs`     UInt64,\n" +
            "`lifePageUserActiveTimeMs`         UInt64,\n" +
            "`lifePageNetworkRequestDurationMs`          UInt32,\n" +
            "`lifePageNetworkRequestCount`               UInt32,\n" +
            "`LifePageNetworkRequestSuccessDurationMs`   UInt32,\n" +
            "`LifePageNetworkRequestSuccessCount`        UInt32,\n" +
            "`lifePageEventCount`      UInt32,\n" +
            "`lifePageUserEventCount`     UInt32,\n" +
            "`lifePageErrorEventCount`     UInt32,\n" +
            "`lifePagePageDurationMs`        UInt64,\n" +
            "`intvAppCrashCount`      UInt32,\n" +
            "`intvStartTimeMs`       DateTime64(3),\n" +
            "`intvEndTimeMs`       DateTime64(3),\n" +
            "`intvSessionDurationMs`     UInt64,\n" +
            "`intvPageDurationMs`      UInt64,\n" +
            "`intvPageLoadDurationMs`     UInt64,\n" +
            "`intvPageLoadSuccessCount`              UInt8,\n" +
            "`intvUserActiveTimeMs`      UInt64,\n" +
            "`intvAppStartupDurationMs`     UInt64,\n" +
            "`intvAppStartupCount`                   UInt32,\n" +
            "`intvNetworkRequestDurationMs`          UInt64,   \n" +
            "`intvNetworkRequestCount`               UInt32,\n" +
            "`intvNetworkRequestSuccessDurationMs`   UInt64,\n" +
            "`intvNetworkRequestSuccessCount`        UInt32,\n" +
            "`intvEventCount`       UInt32,\n" +
            "`intvUserEventCount`      UInt32,\n" +
            "`intvErrorEventCount`      UInt32,\n" +
            "`intvIsJustSessionStarted`     UInt8,\n" +
            "`intvIsJustPageSwitched`     UInt8,\n" +
            "`intvPageEndStatus`                     UInt8,\n" +
            "`intvConvivaExtraDurationMsMetrics`             JSON,\n" +
            "`intvConvivaExtraDurationCountMetrics`          JSON,\n" +
            "`intvConvivaExtraCountMetrics`                  JSON,\n" +
            "`intvConvivaExtraConversionSuccessCountMetrics` JSON,\n" +
            "`intvConvivaExtraConversionFailureCountMetrics` JSON,\n" +
            "`intvCustomDurationMsMetrics`               JSON,\n" +
            "`intvCustomDurationCountMetrics`            JSON,\n" +
            "`intvCustomConversionSuccessCountMetrics`   JSON,\n" +
            "`intvCustomConversionFailureCountMetrics`   JSON,\n" +
            "`intvCustomConversionHasAttemptMetrics`     JSON,\n" +
            "`intvCustomConversionHasSuccessMetrics`     JSON,\n" +
            "`intvEventName`       Array(String),\n" +
            "`intvEventCategory`      Array(String)";
}


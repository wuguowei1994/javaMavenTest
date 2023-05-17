package com.wuguowei.test.column;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParquetSchema {

    public static void main(String[] args) {
        Map<String, String> columnTypeMap = new HashMap<>();
        columnTypeMap.put("String", "String");
        columnTypeMap.put("Int32", "INT_32");
        columnTypeMap.put("UInt32", "UINT_32");
        columnTypeMap.put("JSON", "String");
        columnTypeMap.put("UInt8", "UINT_8");
        columnTypeMap.put("DateTime64(3)", "INT64");
        columnTypeMap.put("UInt64", "UINT_64");
        columnTypeMap.put("LowCardinality(String)", "String");
        columnTypeMap.put("Int64", "INT64");
        columnTypeMap.put("Array(String)", "{\"type\" : \"array\", \"items\" : \"string\"}");

        String str =
                "{"
                        + "\"type\": \"record\","
                        + "\"name\": \"TLBRecord\","
                        + "\"namespace\": \"com.conviva\","
                        + "\"fields\": [";

        Map<String, String> fieldMap = Table2ColumnMap.getColumnMap();

        String result =
                fieldMap.entrySet().stream()
                        .map(
                                entry -> {
                                    String originalType = entry.getValue();
                                    if (!columnTypeMap.containsKey(originalType)) {
                                        throw new RuntimeException(
                                                String.format(
                                                        "error: key %s not defined!",
                                                        originalType));
                                    }
                                    String mappedType = columnTypeMap.get(originalType);
                                    if (originalType.equals("Array(String)")) {
                                        return String.format(
                                                "{\"name\":\"%s\", \"type\":%s}",
                                                entry.getKey(), mappedType);
                                    } else {
                                        return String.format(
                                                "{\"name\":\"%s\", \"type\":\"%s\"}",
                                                entry.getKey(), mappedType);
                                    }
                                })
                        .collect(Collectors.joining(", "));
        str = str + result + "]" + "}";
        System.out.println(str);
    }
}

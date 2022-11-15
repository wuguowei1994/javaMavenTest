package com.wuguowei.test.column;

import java.util.Map;
import java.util.stream.Collectors;

/*
record.put("abc", row.getAs("abc"));
 */

public class SparkSqlCode {

    public static void main(String[] args) {
        Map<String, String> fieldMap = Table2ColumnMap.getColumnMap();

        String normalStr = "record.put(\"%s\", row.getAs(\"%s\"))";
        String result =
                fieldMap.keySet().stream()
                        .map(
                                columnName -> String.format(normalStr, columnName, columnName))
                        .collect(Collectors.joining("; "));
        System.out.println(result);

        System.out.println("Array(String) columns and index:");
        int index = 0;
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            if (entry.getValue().equals("Array(String)")) {
                System.out.println("Key: " + entry.getKey() + ", Index: " + index);
            }
            index++;
        }
    }
}

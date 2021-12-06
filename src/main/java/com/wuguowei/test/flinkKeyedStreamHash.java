package com.wuguowei.test;

import com.google.common.collect.ImmutableSet;
import org.apache.flink.util.MathUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class flinkKeyedStreamHash {
    // public static final int DEFAULT_LOWER_BOUND_MAX_PARALLELISM = 1 << 7;
    public static final int DEFAULT_LOWER_BOUND_MAX_PARALLELISM = 256;
    private static final int parallelism = 256;
    private static final String postfix = "bb4177-34ff-45ff-88e9-5d7a4c1e8fbd";

    public static void main(String[] args) {
        /*
        String a1 = "77";
        String a2 = "39";
        System.out.println("77 hash code: " + a1.hashCode());
        System.out.println("39 hash code: " + a2.hashCode());

        System.out.println("77 murmurHash: " + MathUtils.murmurHash(a1.hashCode()));
        System.out.println("39 murmurHash: " + MathUtils.murmurHash(a2.hashCode()));

        System.out.println("77 res % 128: " + MathUtils.murmurHash(a1.hashCode()) % 128);
        System.out.println("39 res % 128: " + MathUtils.murmurHash(a2.hashCode()) % 128);
        if (1 < 2) return;
         */
        /*
         System.out.println(partitionId("77"));
         System.out.println(partitionId("39"));
         System.out.println(partitionIdMyself("77"));
         System.out.println(partitionIdMyself("39"));
        */
        ArrayList<Integer> res = new ArrayList<>(prefix.size());
        for (String str : prefix) {
            res.add(partitionId(str + postfix));
        }
        Collections.sort(res);
        for (Integer a : res) {
            System.out.println(a);
        }
    }

    private static int partitionIdMyself(Object key) {
        return (MathUtils.murmurHash(key.hashCode()) % DEFAULT_LOWER_BOUND_MAX_PARALLELISM)
                * parallelism
                / DEFAULT_LOWER_BOUND_MAX_PARALLELISM;
    }

    private static int partitionId(Object key) {
        return computeOperatorIndexForKeyGroup(assignToKeyGroup(key));
    }

    private static int assignToKeyGroup(Object key) {
        return computeKeyGroupForKeyHash(key.hashCode());
    }

    private static int computeOperatorIndexForKeyGroup(int keyGroupId) {
        return keyGroupId * parallelism / DEFAULT_LOWER_BOUND_MAX_PARALLELISM;
    }

    private static int computeKeyGroupForKeyHash(int keyHash) {
        return MathUtils.murmurHash(keyHash) % DEFAULT_LOWER_BOUND_MAX_PARALLELISM;
    }

    private static final Set<String> prefix =
            ImmutableSet.of(
                    "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0a", "0b", "0c",
                    "0d", "0e", "0f", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                    "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26",
                    "27", "28", "29", "2a", "2b", "2c", "2d", "2e", "2f", "30", "31", "32", "33",
                    "34", "35", "36", "37", "38", "39", "3a", "3b", "3c", "3d", "3e", "3f", "40",
                    "41", "42", "43", "44", "45", "46", "47", "48", "49", "4a", "4b", "4c", "4d",
                    "4e", "4f", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5a",
                    "5b", "5c", "5d", "5e", "5f", "60", "61", "62", "63", "64", "65", "66", "67",
                    "68", "69", "6a", "6b", "6c", "6d", "6e", "6f", "70", "71", "72", "73", "74",
                    "75", "76", "77", "78", "79", "7a", "7b", "7c", "7d", "7e", "7f", "80", "81",
                    "82", "83", "84", "85", "86", "87", "88", "89", "8a", "8b", "8c", "8d", "8e",
                    "8f", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9a", "9b",
                    "9c", "9d", "9e", "9f", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8",
                    "a9", "aa", "ab", "ac", "ad", "ae", "af", "b0", "b1", "b2", "b3", "b4", "b5",
                    "b6", "b7", "b8", "b9", "ba", "bb", "bc", "bd", "be", "bf", "c0", "c1", "c2",
                    "c3", "c4", "c5", "c6", "c7", "c8", "c9", "ca", "cb", "cc", "cd", "ce", "cf",
                    "d0", "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "da", "db", "dc",
                    "dd", "de", "df", "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9",
                    "ea", "eb", "ec", "ed", "ee", "ef", "f0", "f1", "f2", "f3", "f4", "f5", "f6",
                    "f7", "f8", "f9", "fa", "fb", "fc", "fd", "fe", "ff");
}

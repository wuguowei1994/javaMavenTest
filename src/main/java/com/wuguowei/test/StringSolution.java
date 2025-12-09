package com.wuguowei.test;

public class StringSolution {

    // ["flower","flow","flight"]
    // fl
    public static void main(String[] args) {
        String[] input = new String[]{"flower", "flower", "flower"};

        System.out.println(findCommont(input));
    }

    public static String findCommont(String[] input) {
        int maxRight = 0;

        for (int right = 1; right < input[0].length() + 1; right++) {
            System.out.println("right:" + right);

            String common = input[0].substring(0, right);

            System.out.println("common:" + common);

            for (int i = 1; i < input.length; i++) {
                if (input[i].startsWith(common)) {
                    if (i == input.length - 1) {
                        maxRight = right;
                    }
                } else {
                    break;
                }
            }
        }

        return input[0].substring(0, maxRight);
    }
}

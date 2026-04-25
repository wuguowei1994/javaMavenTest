package com.wuguowei.test;

public class CommonStringInArray
{

    // ["flower","flow","flight"]
    // fl
    public static void main(String[] args) {
        String[] input = new String[]{"flower","flow","flight"};

        System.out.println("result:" + findCommon(input));
    }

    public static String findCommon(String[] input) {
        int maxRightIndex = 0;

        for (int right = 1; right < input[0].length() + 1; right++) {
            System.out.println("right:" + right);

            String common = input[0].substring(0, right);

            System.out.println("common:" + common);

            for (int i = 1; i < input.length; i++) {
                if (input[i].startsWith(common) &&
                    (i == input.length - 1)) {
                        maxRightIndex = right;
                } else {
                    break;
                }
            }
        }

        return input[0].substring(0, maxRightIndex);
    }
}

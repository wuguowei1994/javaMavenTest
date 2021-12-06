package com.wuguowei.test;

public class TryCatchTest {
    public static void main(String[] args) {
        int a = 0, b = 5;
        String c[] = {"A", "B", "C"};
        try {
            for (int i = 1; i < 4; i++) {
                System.out.println(c[i]);
            }
            System.out.println(a / b + b / a);
        } catch (ArithmeticException e) {
            System.out.println("D");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("E");
        } catch (Exception e) {
            System.out.println("max exception");
        }
    }
}

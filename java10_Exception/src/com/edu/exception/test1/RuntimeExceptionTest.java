package com.edu.exception.test1;

public class RuntimeExceptionTest {

    public static void main(String[] args) {
        String[] str = {
                "Hello",
                "No, I mean it",
                "Nice to meet you"
        };

        int i = 0;
        while (i <= 3) {
            try {
                System.out.println(str[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Nice catch!!!!!1111");
            } catch (ArithmeticException e) {
                System.out.println("Nice catch!!!!!222");
            } catch (Exception e) {
                System.out.println("Nice catch!!!!!3333");
            }

            System.out.println(str[i]);
            i++;
        }

        System.out.println("while looping end...");

    }
}

package com.github.siberianintegrationsystems;

public class Unit1 {

private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
            + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


    public static void main(String[] args) {
        String result = INPUT_STRING;
        String g = revertString(result);
        checkResult(g);
    }

    /**
     * При реализации метода нельзя использовать метод reverse() из класса StringBuilder
     */

    private static String revertString(String inputString) {
        String rightPart;
        String leftPart;

        int length = inputString.length();

        if (length <= 1) {
            return inputString;
        }

        leftPart = inputString.substring(0, length / 2);

        rightPart = inputString.substring(length / 2, length);

        return revertString(rightPart) + revertString(leftPart);
    }

    private static void checkResult(String result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}
package com.github.siberianintegrationsystems;

public class Unit1 {

    private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
        + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


    public static void main(String[] args) {
        String result = revertString();
        checkResult(result);
    }

    /**
     * При реализации метода нельзя использовать метод reverse() из класса StringBuilder
     */
    private static String revertString() {
        if (INPUT_STRING.length() == 0) {
            System.out.println("empty string");
            return "";
        } else {
            String newSting = new String();
            for (int i = INPUT_STRING.length() - 1; i > -1; i--) {
                newSting = newSting.concat(INPUT_STRING.substring(i, i + 1));
            }
            ;
            return newSting;
        }
    }

    private static void checkResult(String result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}

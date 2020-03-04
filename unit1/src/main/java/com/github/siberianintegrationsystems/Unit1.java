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

    private static void swap(int leftCharacterIndex, int rightCharacterIndex, char [] word)
    {
        char leftCharacterTemp = word[leftCharacterIndex];
        word[leftCharacterIndex] = word[rightCharacterIndex];
        word[rightCharacterIndex] = leftCharacterTemp;
    }

    private static String revertString() {
        char[] inputString = INPUT_STRING.toCharArray();
        int stringLength = inputString.length;

        for(int index = 0; index < stringLength/2; index++)
            swap(index, (stringLength-index-1), inputString);

        return String.valueOf(inputString);
    }

    private static void checkResult(String result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}

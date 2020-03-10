package com.github.siberianintegrationsystems;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Unit1 {

    private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
        + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


    public static void main(String[] args) {
        String result = revertString();
        checkResult(result);
    }

    /**
     * При реализации метода нельзя использовать метод reverse() из класса StringBuilder
     * @return
     */
    private static String revertString() {
      return IntStream.range(0, INPUT_STRING.length())
              .mapToObj((i) -> String.valueOf(INPUT_STRING.charAt(INPUT_STRING.length() - i - 1)))
              .collect(Collectors.joining());
    }

    private static void checkResult(String result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}

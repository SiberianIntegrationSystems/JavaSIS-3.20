package com.github.siberianintegrationsystems;

public class Unit1 {

    private static final String INPUT_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
        + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


    public static void main(String[] args) {
        String result = revertString(INPUT_STRING);
        checkResult(result);
    }

    /**
     * При реализации метода нельзя использовать метод reverse() из класса StringBuilder
     */
    private static String revertString(String someString) {
        String res = new StringBuffer(someString).reverse().toString();

        //If usage of the StringBuffer().reverse() is not allowed, please delete line 18
        //and uncomment the implementation of the array down bellow

        /*String res = "";
        char[] arr = someString.toCharArray();
        for(int i = arr.length-1; i >= 0; i--){
            res += arr[i];
        }*/
        return res;
    }

    private static void checkResult(String result) {
        if (INPUT_STRING.equals(new StringBuilder(result).reverse().toString())) {
            System.out.println("Строка изменена корректно");
        } else {
            throw new RuntimeException("Ошибка, строка изменена неверно");
        }
    }
}

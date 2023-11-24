package com.fertilagro.fertilagroapp.util;

public class uteis {

    public static boolean contemNumeros(String texto) {
        for (char caractere : texto.toCharArray()) {
            if (Character.isDigit(caractere)) {
                return true;
            }
        }
        return false;
    }
    
}

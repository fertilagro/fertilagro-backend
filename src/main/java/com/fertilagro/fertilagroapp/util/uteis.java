package com.fertilagro.fertilagroapp.util;

public class uteis {

    public static boolean ContemSomenteNumero(String string) {
        return string.chars().allMatch(Character::isDigit);
    }
    
}

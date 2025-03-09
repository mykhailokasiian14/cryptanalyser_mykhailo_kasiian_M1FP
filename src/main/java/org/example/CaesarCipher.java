package org.example;

 class CaesarCipher {
    private static final char[] ALPHABET_EN = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

     String encryptText(String text, int key) {
        return chipher(text, key);
    }

     String decryptText(String text, int key) {
        return chipher(text, -key);
    }

    //метод, що шифрує чи дешифрує, залежно від того, який ключ в нього передано
    //більш підходящої назви, крім "шифр", не придумав ;)
    private String chipher(String text, int key) {
        int textLength = text.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            char shiftedChar = getShiftedChar(currentChar, key);
            result.append(shiftedChar);
        }
        return result.toString();
    }

    private char getShiftedChar(char currentChar, int key){
        int alphabetLength = ALPHABET_EN.length;

        for (int j = 0; j < alphabetLength; j++) {
            if (currentChar == ALPHABET_EN[j]) {
                int newIndex = (j + key) % alphabetLength;
                if (newIndex < 0) {
                    newIndex += alphabetLength;
                }
                return ALPHABET_EN[newIndex];
            }
        }
        return currentChar;
    }

}

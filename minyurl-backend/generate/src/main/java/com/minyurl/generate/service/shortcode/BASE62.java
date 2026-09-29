package com.minyurl.generate.service.shortcode;


public class BASE62 {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();


    public static String encode(long number) {
        if (number == 0) {
            return ALPHABET.substring(0, 1);
        }

        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % BASE);
            sb.append(ALPHABET.charAt(remainder));
            number /= BASE;
        }


        return sb.reverse().toString();
    }
}

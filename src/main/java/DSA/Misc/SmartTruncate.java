package DSA.Misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartTruncate {

    @Test
    void testSmartTruncate() {
        assertEquals("I want to",smartTruncate("I want to eat an apple", 10));
        assertEquals("I want to eat",smartTruncate("I want to eat an apple", 14));
        assertEquals("I want to eat",smartTruncate("I want to eat  an apple", 15));
        assertEquals("I want to eat",smartTruncate("I want to eat an apple", 13));
        assertEquals("I want to eat an apple",smartTruncate("I want to eat an apple", 66));
    }



    private String smartTruncate(String str, int k) {
        if(k-1 >= str.length()) return str;
        if(str.charAt(k-1) == ' ') {
            return str.substring(0, k-1).trim();
        }

        while(k<str.length() && str.charAt(k) != ' ') {
            k++;
        }

        return str.substring(0, k).trim();

    }
}

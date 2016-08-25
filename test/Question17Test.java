import org.junit.Test;
import questions.Question17;

import static org.junit.Assert.assertEquals;

public class Question17Test {
    private Question17 q17 = new Question17();

    @Test
    public void makeNumberFrom0To9IntoWords() throws Exception {
        String result = q17.makeNumberUpTo1000IntoWords(0);
        assertEquals("zero", result);
        result = q17.makeNumberUpTo1000IntoWords(5);
        assertEquals("five", result);
        result = q17.makeNumberUpTo1000IntoWords(9);
        assertEquals("nine", result);
    }

    @Test
    public void makeNumberFrom10To19IntoWords() throws Exception {
        String result = q17.makeNumberUpTo1000IntoWords(10);
        assertEquals("ten", result);
        result = q17.makeNumberUpTo1000IntoWords(15);
        assertEquals("fifteen", result);
        result = q17.makeNumberUpTo1000IntoWords(19);
        assertEquals("nineteen", result);
    }

    @Test
    public void makeNumberFrom20To99IntoWords() throws Exception {
        String result = q17.makeNumberUpTo1000IntoWords(20);
        assertEquals("twenty", result);
        result = q17.makeNumberUpTo1000IntoWords(25);
        assertEquals("twenty-five", result);
        result = q17.makeNumberUpTo1000IntoWords(99);
        assertEquals("ninety-nine", result);
    }

    @Test
    public void makeNumberFrom100To999IntoWords() throws Exception {
        String result = q17.makeNumberUpTo1000IntoWords(100);
        assertEquals("one hundred ", result);
        result = q17.makeNumberUpTo1000IntoWords(120);
        assertEquals("one hundred and twenty", result);
        result = q17.makeNumberUpTo1000IntoWords(325);
        assertEquals("three hundred and twenty-five", result);
        result = q17.makeNumberUpTo1000IntoWords(999);
        assertEquals("nine hundred and ninety-nine", result);
    }

    @Test
    public void makeNumber1000IntoWords() throws Exception {
        String result = q17.makeNumberUpTo1000IntoWords(1000);
        assertEquals("one thousand", result);
    }
}
package rewqty;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void testZeroStringException() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignWrongException() {
        Integer.decode("1-22");
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectStringException() {
        Integer.decode("incorrect");
    }

    @Test
    public void testBase8() {
        assertEquals(Integer.decode("0126"), Integer.valueOf(86));
        assertEquals(Integer.decode("01000"), Integer.valueOf(512));
        assertEquals(Integer.decode("01"), Integer.valueOf(1));
    }

    @Test
    public void testSignBase8() {
        assertEquals(Integer.decode("-0126"), Integer.valueOf(-86));
        assertEquals(Integer.decode("+01000"), Integer.valueOf(512));
    }

    @Test
    public void testBase16() {
        assertEquals(Integer.decode("0X11"), Integer.valueOf(17));
        assertEquals(Integer.decode("0x30"), Integer.valueOf(48));
        assertEquals(Integer.decode("#50"), Integer.valueOf(80));
        assertEquals(Integer.decode("0xaF"), Integer.valueOf(175));
    }

    @Test
    public void testSignBase16() {

        assertEquals(Integer.decode("-0X11"), Integer.valueOf(-17));
        assertEquals(Integer.decode("-0x30"), Integer.valueOf(-48));
        assertEquals(Integer.decode("+#50"), Integer.valueOf(80));
        assertEquals(Integer.decode("+0xaF"), Integer.valueOf(175));;
    }

    @Test
    public void testBase10() {
        assertEquals(Integer.decode("1"), Integer.valueOf(1));
        assertEquals(Integer.decode("10"), Integer.valueOf(10));
        assertEquals(Integer.decode("20000"), Integer.valueOf(20000));
    }

    @Test
    public void testSignBase10() {
        assertEquals(Integer.decode("+1"), Integer.valueOf(1));
        assertEquals(Integer.decode("-10"), Integer.valueOf(-10));
    }
}
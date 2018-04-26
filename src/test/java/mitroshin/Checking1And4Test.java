package mitroshin;

import org.junit.Test;

import static org.junit.Assert.*;

public class Checking1And4Test {

    @Test
    public void are1And4CorrectlyCheckedInArray() throws Exception {
        int[] ints = {1, 4};
        assertTrue("1 and 4 not checked", HomeWork6.checkFor1And4InArray(ints));
    }

    @Test
    public void are1And4CorrectlyCheckedInArray2() throws Exception {
        int[] ints = {1, 6, 7, 4, 3, 8, 9};
        assertTrue("1 and 4 in big arrray not checked",HomeWork6.checkFor1And4InArray(ints));
    }

    @Test
    public void are1And4CorrectlyCheckedInArray3() throws Exception {
        int[] ints = {1, 6, 7, 3, 8, 9};
        assertFalse("only 1 in array",HomeWork6.checkFor1And4InArray(ints));
    }

    @Test
    public void are1And4CorrectlyCheckedInArray4() throws Exception {
        int[] ints = {6, 7, 4, 8, 9};
        assertFalse("only 4 in array",HomeWork6.checkFor1And4InArray(ints));
    }

    @Test
    public void are1And4CorrectlyCheckedInArray5() throws Exception {
        int[] ints = {6, 7, 4, 8, 9};
        assertFalse("neither 1 or 4 in array",HomeWork6.checkFor1And4InArray(ints));
    }
}

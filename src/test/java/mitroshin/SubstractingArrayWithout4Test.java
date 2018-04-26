package mitroshin;

import org.junit.Test;

public class SubstractingArrayWithout4Test {
    @Test(expected = RuntimeException.class)
    public void isExceptionThrownIfThereIsNo4() throws Exception {
        int[] ints = {0, 5, 6, 7, 8, 6};
        HomeWork6.getArrayAfterLastFour(ints);
    }
}

/**
 * Java3. HomeWork6
 * @author Yury Mitroshin
 * @version dated March 6, 2018
 * @link https://github.com/yurchess
*/
package mitroshin;

import java.util.Arrays;

public class HomeWork6 {
    public static void main(String[] args) {
        // task1
        int[] ints = {0, 2, 3, 4, 5, 4, 3, 6, 2};
        System.out.println(Arrays.toString(getArrayAfterLastFour(ints)));
    }

    public static int[] getArrayAfterLastFour(int[] inArr) throws RuntimeException {
        int pos4 = -1;
        for (int i = inArr.length - 1; i >= 0; i--) {
            if (inArr[i] == 4) {
                pos4 = i;
                break;
            }
        }
        if (pos4 == -1) {
            throw new RuntimeException();
        } else {
            return Arrays.copyOfRange(inArr, pos4 + 1, inArr.length);
        }
    }

    public static boolean checkFor1And4InArray(int[] ints) {
        boolean is1, is4 = false;
        is1 = is4 = false;

        for (int elem : ints) {
            is1 |= elem == 1;
            is4 |= elem == 4;
            if (is1 && is4) {
                return true;
            }
        }
        return false;
    }
}
